package org.Sem2.Lab1.task1_3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Производитель - потребитель");

        Store store = new Store();
        Introducer introducer = new Introducer(store);
        Customer customer = new Customer(store);

        new Thread(introducer).start();
        new Thread(customer).start();
    }
}

class Store {
    private int products = 0;

    public synchronized void get() {
        while (products < 1) {
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        products--;
        System.out.println("Потребитель сделал своё дело");
        System.out.println("Осталось товаров: " + products);
        notify();
    }

    public synchronized void put() {
        while (products >= 5) {
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        products++;
        System.out.println("Производитель создал товар.");
        System.out.println("Осталось товаров: " + products);
        notify();
    }
}

class Introducer implements Runnable {
    private final Store store;
    private final int totalProductions = 5;

    Introducer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < totalProductions; i++) {
            store.put();
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer implements Runnable {
    private final Store store;
    private final int totalConsumptions = 5;

    Customer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < totalConsumptions; i++) {
            store.get();
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
