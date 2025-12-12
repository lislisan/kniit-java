package org.kniit.lab10.task19;

public class MaxFinder {

    public static <T extends Comparable<T>> T findMax(T[] array) {

        if (array == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }

        T max = array[0];

        for (T element : array) {
            if (element == null) {
                throw new IllegalArgumentException("Элементы массива не могут быть null");
            }

            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }
}