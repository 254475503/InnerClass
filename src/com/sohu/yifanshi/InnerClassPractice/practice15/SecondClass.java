package com.sohu.yifanshi.InnerClassPractice.practice15;

public class SecondClass {
    public FirstClass  getFirstClass(String name)
    {
        return new FirstClass(name);
    }

    public FirstClass getFirstClassByNonameInner(String name)
    {
        return  new FirstClass(name)
        {

        };
    }
}
