package org.Sem2.Lab1.task1_5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Conveyor {
    public static void main(String[] args) {
        BlockingQueue<String> stampedParts  = new LinkedBlockingQueue<>(5); // заготовки
        BlockingQueue<String> assembledParts = new LinkedBlockingQueue<>(5); // готовые детали

        Stamper stamper = new Stamper(stampedParts);
        Assembler assembler = new Assembler(stampedParts, assembledParts);
        QualityControl qc = new QualityControl(assembledParts);

        new Thread(stamper, "Штамповщик").start();
        new Thread(assembler, "Сборщик").start();
        new Thread(qc, "Контроль-качества").start();
    }
}

class Stamper implements Runnable {
    private final BlockingQueue<String> stampedParts;
    private int total = 10;

    public Stamper(BlockingQueue<String> stampedParts) {
        this.stampedParts = stampedParts;
    }

    @Override
    public void run() {
        for (int i = 1; i <= total; i++) {
            String part = "Заготовка-" + i;
            try {
                stampedParts.put(part);
                System.out.println("[Штамповщик] вырезал: " + part);
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("[Штамповщик] закончил работу.");
    }
}

class Assembler implements Runnable {
    private final BlockingQueue<String> stampedParts;
    private final BlockingQueue<String> assembledParts;

    public Assembler(BlockingQueue<String> stampedParts,
                     BlockingQueue<String> assembledParts) {
        this.stampedParts = stampedParts;
        this.assembledParts = assembledParts;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                String stamped = stampedParts.take();
                String assembled = "Готовая деталь из " + stamped;
                assembledParts.put(assembled);
                System.out.println("[Сборщик] собрал: " + assembled);
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

class QualityControl implements Runnable {
    private final BlockingQueue<String> assembledParts;
    private final BlockingQueue<String> shelf = new LinkedBlockingQueue<>();

    public QualityControl(BlockingQueue<String> assembledParts) {
        this.assembledParts = assembledParts;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                String part = assembledParts.take();
                System.out.println("[Контроль] принял: " + part + " → отправлен на склад");
                shelf.offer(part);
                Thread.sleep(600);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            if (shelf.size() >= 10) {
                System.out.println("[СКЛАД] Достигнуто 10 деталей, остановка...");
                break;
            }
        }
        System.out.println("[Контроль] завершает работу.");
    }
}
