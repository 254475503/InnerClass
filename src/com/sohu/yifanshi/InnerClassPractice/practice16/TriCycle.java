package com.sohu.yifanshi.InnerClassPractice.practice16;

public class TriCycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("ride TriCycle");
    }

    private TriCycle(){}

    public static CycleFactory TriCycleFactory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new TriCycle();
        }
    };
}
