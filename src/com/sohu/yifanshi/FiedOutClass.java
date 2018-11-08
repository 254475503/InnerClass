package com.sohu.yifanshi;

public class FiedOutClass {
    private int age = 12;
    public void printAge()
    {
        System.out.println(age);
    }
    public void testFunction(int X,final int Y)//在jdk1.8之前局部内部类的方法(构造函数除外)需要使用外部传入的参数，则需要将参数设置为final。
    {
        class FieldInnerClass{
            private int a;
            private int b;
            public FieldInnerClass(int x,int y)
            {//局部内部类的构造函数若要使用外部参数X,Y没必要设置为final的
                this.a = X;
                this.b = Y;
            }
            public void printX()
            {
                System.out.println(X);//在jdk1.8之前，这里会报错。原因是因为局部内部类和局部参数在jvm虚拟机中的生命周期不同
                //首先，这个局部内部类的方法存在的情况下，必定要访问局部变量X。所以局部内部类依然存活的情况下，他的方法使用到的
                //局部变量也必须存活，这是前提。不然这个局部内部类将失去意义。但是在jvm中，局部变量随着方法的执行而创建，随着方法
                //的执行结束而销毁。但是，局部内部类和其他类一样，当第一次创建对象时被加载，当对象再也不被引用，才可能会被GC。所以，
                //这样就可能存在局部内部类依然存在，但是局部变量已经销毁的情况。为了避免这种情况发生，我们就需要将局部变量加上final变为
                //常量储存在常量池中。这样，局部常量不会随意被销毁，也就不会出现上面的情况。
                System.out.println(Y);
                System.out.println(age);
                printAge();
            }
        }
        FieldInnerClass fieldInnerClass = new FieldInnerClass(X,Y);
        fieldInnerClass.printX();
    }

    public static void main(String[] args) {
        FiedOutClass fiedOutClass = new FiedOutClass();
        fiedOutClass.testFunction(10,20);
    }
}

