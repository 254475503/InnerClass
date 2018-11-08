package com.sohu.yifanshi;

public class StaticOutterClass {
    private static String name = "aaa";
    private String age = "10";
    public String getAge()
    {
        return age;
    }
    public static String getName()
    {
        return name;
    }
    public void test()
    {
        new InnerClass().getId();//依然可以创建内部类对象调用其方法。
        new InnerClass().getStaticField();
        getName();
        getAge();
    }

    public static void staticTest()
    {
        new InnerClass().getId();//依然可以创建内部类对象调用其方法。
        new InnerClass().getStaticField();//外部类可以通过内部类对象访问内部类的实例成员变量/方法；
        InnerClass.getStaticField();//对于内部类的静态域/方法，外部类可以通过内部类类名访问。
        getName();
        //getAge();static方法无法直接调用非static方法
        new StaticOutterClass().getAge();//此外还发现了一个惊人的事实，static方法中，不能调用非static方法，但是，可以调用一个已经
        //实例化了的对象的static方法。原因是static方法可以在不使用this指针的情况下调用，但是直接调用该类的非static方法是需要传入this指针的。

    }
    static class InnerClass{//static内部类能且仅能操作外部类被static修饰的成员与方法
        private String id = "ss";
        private static String staticField = "staticField";

        public static String getStaticField() {
            return staticField;
        }

        public static void setStaticField(String staticField) {
            InnerClass.staticField = staticField;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void print()
        {
            //System.out.println(StaticOutterClass.this.age); static内部类无法这样获得外部类对象。
            System.out.println(name);//能直接访问static修饰的成员
            //System.out.println(age);不能访问非static的成员
            getName();//能直接调用外部static方法

        }
    }

    public static void main(String[] args) {
        StaticOutterClass staticOutterClass = new StaticOutterClass();
        StaticOutterClass.InnerClass.getStaticField();
        InnerClass.getStaticField();//可以直接通过类名获得static内部类中的static成员
        StaticOutterClass.InnerClass innerClass = new StaticOutterClass.InnerClass();//不需要通过外部类来创建内部类对象,应为static内部
        //类和外部类没有依赖关系。这里的外部类依然只是申明这个内部类是哪一个外部类的内部类
        innerClass.getId();
    }
}
