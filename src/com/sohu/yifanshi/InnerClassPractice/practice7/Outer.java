package com.sohu.yifanshi.InnerClassPractice.practice7;

public class Outer {
    private String name;
    private void printName()
    {
        System.out.println(this.name);
    }
    class Inner{
        private String innerPrivatefield = "";
        private void sayHi()
        {
            System.out.println("Hi I am Inner class");
        }
        void editAndPrint(String name)
        {
            Outer.this.name = name;
            Outer.this.printName();
        }
    }
    public void editAndPrintByInner(String name)
    {
        Outer.Inner inner = this.new Inner();
        inner.editAndPrint(name);
    }
    public void tryinnerPrivate()
    {
        System.out.println(this.new Inner().innerPrivatefield);
        this.new Inner().sayHi();
    }
    public void editAndPrintByNonameInner( String name)
    {//在这里我尝试了一下用匿名内部类调用这个方法。发现这里的参数是不用设置为final的。所以我们可以推测出，匿名内部类调用方法是直接
        //使用了外层方法传入的参数，并不是复制的副本。只有传入匿名内部类的参数我们操作的才是他的复制。
        this.new Inner()
        {

        }.editAndPrint(name);

    }


    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.editAndPrintByInner("aaa");
        outer.editAndPrintByInner("bbb");
        outer.editAndPrintByNonameInner("ccc");
        outer.printName();
        outer.tryinnerPrivate();//事实证明，外部类是可以访问内部类的private方法和成员变量的
    }
}
