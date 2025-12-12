package org.kniit.lab10.task23;

public class TypePrinter {

    public static void printType(Object obj) {
        if (obj == null) {
            System.out.println("null");
            return;
        }

        Class<?> clazz = obj.getClass();
        System.out.println(clazz.getName());
    }
}