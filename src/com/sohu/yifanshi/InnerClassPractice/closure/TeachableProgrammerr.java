package com.sohu.yifanshi.InnerClassPractice.closure;

public class TeachableProgrammerr extends Programmer implements Teachable {
    public static void main(String[] args) {
        TeachableProgrammerr teachableProgrammerr  = new TeachableProgrammerr();
        teachableProgrammerr.work();
        Teachable teachable = new TeachableProgrammerr();
        teachable.work();
    }
}
