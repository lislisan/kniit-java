package org.Sem2.Lab1.task1_4;

public class Main {
    public static void main(String[] args){
        System.out.println("Перекресток: светофор и машины");
        TrafficLight trafficLight = new TrafficLight();

        new Thread(trafficLight).start();

        try { Thread.sleep(100); } catch (InterruptedException e) { }

        Car car1 = new Car("Машина 1", trafficLight);
        Car car2 = new Car("Машина 2", trafficLight);
        Car car3 = new Car("Машина 3", trafficLight);

        new Thread(car1).start();
        new Thread(car2).start();
        new Thread(car3).start();
    }
}

class TrafficLight implements Runnable {
    private boolean isGreen = false;

    public synchronized void waitForGreen(String carName) {
        while (!isGreen) {
            try {
                System.out.println(carName + " стоит на красный свет...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(carName + " проезжает перекресток на зеленый!");
    }

    public void run() {
        while (true) {
            synchronized (this) {
                isGreen = false;
                System.out.println("\nСВЕТОФОР: КРАСНЫЙ! (машины стоят)");
            }

            try { Thread.sleep(2000); } catch (InterruptedException e) { }

            synchronized (this) {
                isGreen = true;
                System.out.println("\nСВЕТОФОР: ЗЕЛЕНЫЙ! (машины едут)");
                notifyAll();
            }

            try { Thread.sleep(2000); } catch (InterruptedException e) { }
        }
    }
}

class Car implements Runnable {
    private String name;
    private TrafficLight trafficLight;

    Car(String name, TrafficLight trafficLight) {
        this.name = name;
        this.trafficLight = trafficLight;
    }

    public void run() {
        while (true) {
            trafficLight.waitForGreen(name);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}