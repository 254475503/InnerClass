package com.sohu.yifanshi.InnerClassPractice.practice21;

public class myImplements implements interfaceWithStaticClass {
    @Override
    public void print() {
        System.out.println("myImplements");
    }

    public static void main(String[] args) {
        myImplements a = new myImplements();
        myImplements.Inner.printOuter(a);
    }
}
