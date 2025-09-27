package org.kniit.lab2.task4;

class Cylinder extends Shape {
    private double radius;
    private double high;

    public Cylinder(double radius, double high) {
        if (radius <= 0) throw new IllegalArgumentException("Радиус должен быть > 0");
        if (high <= 0) throw new IllegalArgumentException("Высота должна быть > 0");
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * high;
    }

}