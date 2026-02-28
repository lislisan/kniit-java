package org.Sem2.Lab1.task1_6;

import java.util.concurrent.*;

public class Race {
    public static void main(String[] args) {
        int runnerCount = 5;

        CyclicBarrier barrier = new CyclicBarrier(runnerCount, () -> {
            System.out.println("\n✨ СТАРТ! Гонка началась.\n");
        });

        ExecutorService executor = Executors.newFixedThreadPool(runnerCount); // фиксированный пул потоков

        for (int i = 0; i < runnerCount; i++) {
            Runner runner = new Runner("Бегун-" + (i + 1), barrier);
            executor.submit(runner); //запуск
        }

        executor.shutdown(); //больше задач добавляться не будет
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS); //все запущенные бегуны завершатся
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n🏁 ФИНИШ!");
    }
}
