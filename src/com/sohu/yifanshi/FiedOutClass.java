package com.sohu.yifanshi;

public class FiedOutClass {
    private int age = 12;
    public void printAge()
    {
        System.out.println(age);
    }
    public void testFunction(int X,final int Y)//在jdk1.8之前局部内部类的方法(构造函数除外)需要使用外部传入的参数，则需要将参数设置为final。
            //jdk1.8不需要加final的原因时，jdk已经检测到内部类访问了局部变量X，则jdk会自动且隐式的为X加上final修饰。正因为如此
            //第23行的X如果赋值时会无法通过编译
    {
        class FieldInnerClass{
            private int a;
            private int b;
            public FieldInnerClass(int x,int y)
            {//局部内部类的构造函数若要使用外部参数X,Y没必要设置为final的
                //this.a = X;
                this.b = Y;
            }
            public void printX()
            {
                //X=3;
                //System.out.println(X);//在jdk1.8之前，这里会报错。原因是因为局部内部类和局部参数在jvm虚拟机中的生命周期不同
                //首先，这个局部内部类的方法存在的情况下，必定要访问局部变量X。所以局部内部类依然存活的情况下，他的方法使用到的
                //局部变量也必须存活，这是前提。不然这个局部内部类将失去意义。但是在jvm中，局部变量随着方法的执行而创建，随着方法
                //的执行结束而销毁。但是，局部内部类和其他类一样，当第一次创建对象时被加载，当对象再也不被引用，才可能会被GC。所以，
                //这样就可能存在局部内部类依然存在，但是局部变量已经销毁的情况。为了避免这种情况发生，我们就需要将局部变量加上final
                //内部类访问被final修饰的局部变量，jvm会将局部变量复制一份，将复制的这一份变为局部内部类的成员变量。这样即使栈中
                // 局部变量（含final）已死亡，但由于它是final的，其值是不会发生改变的，因而内部类对象在局部变量死亡后，
                // 照样可以访问自己内部维护的一个值跟局部变量一样的成员变量，从而解决这个问题。

                //还有一种解释的方法是，局部内部类访问方法的局部变量时，本身就是要把局部变量复制一份编程自己的成员变量来操作的。也就是
                //说内部类操作的参数和方法中的参数，其实不是同一个对象。如果不加上final，那么如果在内部类中改变了传入的参数的值的话，他们
                // 又不是同一个对象，就造成了方法中的局部变量，也就是传入方法的参数，以及内部类的使用的外部类的参数不一致。为了避免这个尴尬的
                //问题，干脆就设置为final让他们不可更改，保证内部类与方法中的参数一致性。（目前我更倾向于这种说法，因为这种说法更契合于final关键字的用法）
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

