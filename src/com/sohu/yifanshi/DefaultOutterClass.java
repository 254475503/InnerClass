package com.sohu.yifanshi;



public class DefaultOutterClass {
    public String outPublicField = "outPublicField";
    private String outPrivateField = "outPrivateField";
    public void outPublicFun()
    {
        System.out.println(outPublicField);
    }
    public void outPrivateFun ()
    {
        System.out.println(outPrivateField);
    }
    public void printInnerX()
    {
        System.out.println(new InnerClass().x);//外部类需要通过内部类的对象访问内部类的所有成员变量/方法。
    }
    class InnerClass extends TestStaticFatherClass{
        static final int x = 2;
        //static int a = 1;成员内部类只能出现static的常量。
        /*public void static say()
        {
            System.out.println();
        } 成员内部类不能出现static方法。但是可以继承有static方法的父类.成员内部类是依附于外围类的，
        所以，只有先创建了外围类对象才能够创建内部类对象。也正是由于这个原因，成员内部类也不能含有 static 的变量和方法*/
        public void print()
        {
            System.out.println(DefaultOutterClass.this.outPrivateField);//在成员内部类使用外部类对象时，使用 outer.this 来表示外部类对象；
            System.out.println(outPublicField);
            System.out.println(outPrivateField);//成员内部类可以直接访问外部类的所有成员和方法，即使是 private 的；
            outPrivateFun();
            outPublicFun();
        }
        private void innerPrivatefun()
        {
            String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
            System.out.println(method+"runed");
        }

    }


    //若内部类被private修饰，那么在外部类中，这些关系没有任何区别。但是在其他地方。想要操作外部类的内部类的话，需要创建内部类的对象
    //但是内部类的对象已经不能通过60行的方法生成了。只能在外部类中，对外提供一个获得内部类的方法。
    public PrivateInnerClass getPrivateInnserClass()
    {
        return new PrivateInnerClass();
    }
    private class PrivateInnerClass extends TestStaticFatherClass{

    }




    public static void main(String[] args) {
        DefaultOutterClass defaultOutterClass = new DefaultOutterClass();
        DefaultOutterClass.InnerClass innerClass = new DefaultOutterClass().new InnerClass();//直接通过外部类调用内部类的方法。但是一般内部类都是
        //为了隐藏起信息，而特意设置为私有的。
        //开头的 Out 是为了标明需要生成的内部类对象在哪个外部类当中；必须先有外部类的对象才能生成内部类的对象。
        PrivateInnerClass privateInnerClass = defaultOutterClass.getPrivateInnserClass();
        innerClass.say();
        innerClass.print();
        innerClass.innerPrivatefun();
    }
}
