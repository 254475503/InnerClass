package com.sohu.yifanshi.InnerClassPractice.ExtendsInnerClass;

public class OuterClass1 {
    protected class InnerClass{
        public InnerClass(){
            System.out.println("OuterClass1.InnerClass()");
        }
        public void f()
        {
            System.out.println("Outerclass1.InnerClass.f()");
        }
    }
    private InnerClass innerClass = new InnerClass();
    public OuterClass1()
    {
        System.out.println("new OuterClass1");
    }
    public void insertInner(InnerClass innerClass)
    {
        this.innerClass = innerClass;
    }
    public void g(){
        this.innerClass.f();
    }
}
