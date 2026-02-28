package org.Sem2.Lab1.task1_2;

public class Restik {
    public static void main(String[] args){
        System.out.println("Ресторан открыт, еды нет, готовим!");
        Table table = new Table();
        Shef shef = new Shef(table);
        Waiter waiter = new Waiter(table);

        new Thread(shef).start();
        new Thread(waiter).start();
    }
}

class Table {
    private int max_dish = 0;

    public synchronized void cook() {
        while (max_dish >= 3) {
            try {
                System.out.println("Стол полон. Повар ждёт...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        max_dish++;
        System.out.println("Приготовлено блюдо и поставлено на стол");
        System.out.println("Блюд на столе: " + max_dish);
        notify();
    }

    public synchronized void waiting() {
        while (max_dish < 1) {
            try {
                System.out.println("Стол пуст. Официант ждёт...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        max_dish--;
        System.out.println("Официант забрал блюдо. Блюд на столе: " + max_dish);
        notify();
    }
}

class Shef implements Runnable {
    private final Table table;
    private final int totalCooked = 10;

    Shef(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        for (int i = 0; i < totalCooked; i++) {
            table.cook();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Waiter implements Runnable {
    private final Table table;
    private final int totalTaken = 10;

    Waiter(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        for (int i = 0; i < totalTaken; i++) {
            table.waiting();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
