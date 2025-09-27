package org.kniit.lab2.task4;

public class Container {
    private double totalVolume;
    private double freeVolume;

    public Container(double volume){
        this.totalVolume = volume;
        this.freeVolume = volume;

        System.out.println("Создан объект объёма " + volume);
    }

    public void add(Shape shape){
        double shapeVolume = shape.getVolume();
        if (shapeVolume <= freeVolume) {
            freeVolume -= shapeVolume;
            System.out.println("Фигура добавлена. Осталось места: " + freeVolume);
        } else {
            System.out.println("Не хватает места!");
        }
    }

}
