package com.sohu.yifanshi.InnerClassPractice.practice10;

public class Outer {
    public void sayGoodBye()
    {
        class InnerClass implements sayGoodBye{


            @Override
            public void sayGoodBye() {
                System.out.println("GoodBye");
            }
        }
    }
}
