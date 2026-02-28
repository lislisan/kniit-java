package org.Sem2.Lab1.task1_6;

import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private final String name;
    private final CyclicBarrier barrier;

    public Runner(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " приготовился на старте...");
            barrier.await(); //

            int runTime = ThreadLocalRandom.current().nextInt(500, 3000);
            Thread.sleep(runTime);

            System.out.println(name + " финишировал за " + runTime + " мс");

        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            System.err.println(name + " прерван: " + e.getClass().getSimpleName());
        }
    }
}
