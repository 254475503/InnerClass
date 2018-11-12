package com.sohu.yifanshi;

public class NoNameOutterClass {
    public TestIntefaceClass testIntefaceClass;
    public TestAbstractClass testAbstractClass;

    public String testString(final String name,String city)//也可以直接调用内部类的方法
    {
        return new TestAbstractClass(name,city)
        {

            @Override
            void print() {
                System.out.println(name);
            }
            String returnName()
            {
                return name;
            }
        }.returnName();
    }

    public TestAbstractClass getTestAbstractClass(String name, final String city)
    {
        return this.testAbstractClass =  new TestAbstractClass(name,city) {//匿名内部类和局部内部类一样，构造函数调用方法局部变量不需要final，但是其他方法
            //用到局部变量需要final
            //匿名内部类由于没有名字，所以他没有自己的构造函数。但是我们又需要创造一个对象，那么就只能用别的类咯。这就是匿名内部类
            //必须继承一个类或者实现一个接口的原因。而且我们又发现了一个创建抽象类对象的方法。
            @Override
            void print() {

                //System.out.println(name);name为加则final报错
                System.out.println(city);
                System.out.println("ccc");
            }
        };
    }

    public TestIntefaceClass getIntefaceClass(final String city)
    {
        return this.testIntefaceClass =  new TestIntefaceClass() {//实现接口的匿名内部类
            @Override
            public void print() {
                System.out.println(city);
            }
        };
    }

    public static void main(String[] args) {
        NoNameOutterClass noNameOutterClass = new NoNameOutterClass();
        noNameOutterClass.getIntefaceClass("beijing");
        noNameOutterClass.getTestAbstractClass("yifanshi","leping");
        noNameOutterClass.testIntefaceClass.print();
        noNameOutterClass.testAbstractClass.print();
        String str =  noNameOutterClass.testString("aaa","bbb");
    }
}
