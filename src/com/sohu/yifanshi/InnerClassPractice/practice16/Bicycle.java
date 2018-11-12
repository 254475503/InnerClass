package com.sohu.yifanshi.InnerClassPractice.practice16;

public class Bicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("ride Bicycle");
    }
    private Bicycle(){}

    public static CycleFactory cycleFactory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}
