package com.sohu.yifanshi.InnerClassPractice.practice1;

import sun.java2d.pipe.OutlineTextRenderer;

public class Outer {
    private String privateString;
    Outer(String privateString)
    {
        this.privateString = privateString;
    }
    public Inner getInner(){
        return new Inner();
    }
    class Inner{
        void showPrivateString()
        {
            System.out.println(privateString);
        }
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer("aaa").new Inner();
        inner.showPrivateString();
    }
}
