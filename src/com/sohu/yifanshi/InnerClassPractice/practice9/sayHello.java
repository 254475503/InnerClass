package com.sohu.yifanshi.InnerClassPractice.practice9;

public interface sayHello {
    public void sayHello();
    class sayHelloInnerClass implements sayHello{

        @Override
        public void sayHello() {
            System.out.println("hello i am sayHelloInnerClass");
        }
    }
}
