package com.sohu.yifanshi.InnerClassPractice.practice16;

public class Factories {
    public static void serviceConsumer(CycleFactory cycleFactory)
    {
        Cycle cycle = cycleFactory.getCycle();
        cycle.ride();
    }

    public static void main(String[] args) {
        serviceConsumer(Bicycle.cycleFactory);
        serviceConsumer(TriCycle.TriCycleFactory);
    }
}
