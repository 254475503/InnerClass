package com.sohu.yifanshi;

public class InheriteInner extends DefaultOutterClass.InnerClass {//继承了一个内部类之后，无参构造函数时不能通过编译的。因为你继承的
    //是一个内部类。内部类的创建是依赖于外部类的。但是我们继承仅仅是继承到了内部类，外部类并没有继承下来，所以必须手动传入一个外部类
    //对象进行初始化。或者直接在无参构造函数中new一个外部类对象来进行初始化
    InheriteInner()
    {
        new DefaultOutterClass().super();
    }
    InheriteInner(DefaultOutterClass defaultOutterClass)
    {
        defaultOutterClass.super();
    }

    public static void main(String[] args) {
        InheriteInner inheriteInner = new InheriteInner(new DefaultOutterClass());
    }
}
