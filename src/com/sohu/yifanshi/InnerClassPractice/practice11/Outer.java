package com.sohu.yifanshi.InnerClassPractice.practice11;

public class Outer {
    private class Inner implements sayNiHao{

        @Override
        public void sayNiHao() {
            System.out.println("nihao");
        }
        public void ordinartMethod()
        {
            System.out.println("ordinaryMethod");
        }
    }
    public sayNiHao getSayNiHao()
    {
        return this.new Inner();
    }

    public static void main(String[] args) {
        sayNiHao sayNiHao = new Outer().getSayNiHao();
        //sayNiHao.ordinaryMethod(); ±¨´í¡£
    }
}
