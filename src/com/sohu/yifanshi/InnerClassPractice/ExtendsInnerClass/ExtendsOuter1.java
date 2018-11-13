package com.sohu.yifanshi.InnerClassPractice.ExtendsInnerClass;

public class ExtendsOuter1 extends  OuterClass1 {

    public class InnerClass extends OuterClass1.InnerClass{
        public InnerClass(){
            System.out.println("ExtendsOuter.Inner()");
        }

        public void f(){
            System.out.println("ExtendsOuter.Inner.f()");
        }

    }

    public ExtendsOuter1()
    {
        insertInner(new InnerClass());
    }

    public static void main(String[] args) {
        OuterClass1 oc1 = new ExtendsOuter1();//运行顺序1.实例化ExtendsOuter1的父类。给字段赋值。赋值时执行了父类13行，输出OuterClass1.InnerClass()
        //2.执行父类构造函数输出new OuterClass1 3.执行本类构造函数，insertInner入栈。4.new InnerClass()入栈这里的innerclass是子类，所以又要先实例化父类。
        //5.执行父类innerclass构造函数输出OuterClass1.InnerClass() 6.执行子类构造函数输出 ExtendsOuter.Inner() newInnerclass出栈，执行insert，insert出栈。

        oc1.g();//7.执行oc1.g这里等号左边是OuterClass1的引用，理应执行父类的g方法。但是再构造函数中，我们将一个子类的inner给insert到了当前的对象。所以我们
        //执行的是子类inner的inner.f()所以输出ExtendsOuter.Inner.f()

    }

}
