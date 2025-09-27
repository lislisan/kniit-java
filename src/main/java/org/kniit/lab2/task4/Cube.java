package org.kniit.lab2.task4;

class Cube extends Shape {
    private double length;

    public Cube(double length){
        if (length <= 0) throw new IllegalArgumentException("Сторона должна быть > 0");
        this.length = length;
    }
    @Override
    public double getVolume() {
        return (Math.pow(length, 3));
    }
}
