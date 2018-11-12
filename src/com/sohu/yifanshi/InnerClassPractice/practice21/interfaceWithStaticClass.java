package com.sohu.yifanshi.InnerClassPractice.practice21;

public interface interfaceWithStaticClass {
    void print();
    class Inner {

        public static void printOuter(interfaceWithStaticClass withStaticClass)
        {
            withStaticClass.print();
        }


    }

}
