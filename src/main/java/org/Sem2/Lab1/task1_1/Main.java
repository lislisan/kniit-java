package org.Sem2.Lab1.task1_1;

public class Main {
    public static void main(String[] args){
        System.out.println("Автозаправочная станция с 2 колонками");
        Station station = new Station();

        for (int i = 1; i <= 5; i++) {
            Car car = new Car("Машина " + i, station);
            new Thread(car).start();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Station {
    private int availableColumns = 2;

    public synchronized void refuel(String carName) {

        while (availableColumns == 0) {
            try {
                System.out.println(carName + " ждет свободную колонку...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        availableColumns--;
        System.out.println(carName + " начала заправку");
        System.out.println("Свободных колонок: " + availableColumns);

        availableColumns++;
        System.out.println(carName + " закончила заправку. Свободных колонок: " + availableColumns);

        notifyAll();
    }
}

class Car implements Runnable {
    private String name;
    private Station station;

    Car(String name, Station station) {
        this.name = name;
        this.station = station;
    }

    @Override
    public void run() {
        System.out.println(name + " приехала на заправку");
        station.refuel(name);
    }
}