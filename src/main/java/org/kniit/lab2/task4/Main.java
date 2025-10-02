package org.kniit.lab2.task4;

// данные размера изменяются вручную
import java.awt.*;

public class Main {
    public static void main(String[] args){
        Container container = new Container(1000.0);

        Shape sphere = new Sphere(5.0);
        Shape bigSphere = new Sphere(3.0);
        Shape cubik = new Cube(4);
        Shape cylindrik = new Cylinder(10, 2);

        container.add(sphere);
        container.add(bigSphere);
        container.add(cubik);
        container.add(cylindrik);
    }
}
