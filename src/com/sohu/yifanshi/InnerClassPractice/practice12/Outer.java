package com.sohu.yifanshi.InnerClassPractice.practice12;

public class Outer {
    private String name = "";
    private void printName()
    {
        System.out.println(this.name);
    }
    public editOuterClass editName(final String name)
    {
        return new editOuterClass(){

            @Override
            public void editOuterClass() {
              Outer.this.name = name;
              printName();
            }

        };
    }
    public void editNameB(final String name)
    {
        new editOuterClass(){

            @Override
            public void editOuterClass() {
                Outer.this.name = name;
                printName();
            }

        }.editOuterClass();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.editName("aaa").editOuterClass();

        outer.printName();

        outer.editNameB("bbb");
        outer.printName();

    }
}
