package com.sohu.yifanshi.InnerClassPractice.practice16;

public class Unicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("ride Unicycle");
    }

    private Unicycle (){}

    public static CycleFactory unicycleFactory =
    new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}
