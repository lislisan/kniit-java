package org.kniit.lab10.task23;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тест 1: Базовые типы");

        TypePrinter.printType(123);
        TypePrinter.printType("Hello");
        TypePrinter.printType(3.14);
        TypePrinter.printType(true);

        System.out.println("\n Тест 2: null и массивы");

        TypePrinter.printType(null);

        int[] intArray = {1, 2, 3};
        String[] strArray = {"a", "b", "c"};
        TypePrinter.printType(intArray);
        TypePrinter.printType(strArray);

    }
}

