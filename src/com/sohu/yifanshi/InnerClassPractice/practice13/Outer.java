package com.sohu.yifanshi.InnerClassPractice.practice13;

public class Outer {
    public defaultInterface getInterface()
    {
        return new defaultInterface() {
            @Override
            public defaultInterface returnInterface() {
                return this;
            }
        };
    }

    public static void main(String[] args) {
        defaultInterface defaultInterface = new Outer().getInterface();
    }
}
