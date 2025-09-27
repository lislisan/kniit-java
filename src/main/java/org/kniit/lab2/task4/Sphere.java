package org.kniit.lab2.task4;

class Sphere extends Shape {
    private double radius;

    public Sphere(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Радиус должен быть > 0");
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

}