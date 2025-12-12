package org.kniit.lab10.task19;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тест 1: Целые числа (Integer)");
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Массив: " + Arrays.toString(numbers));
        System.out.println("Максимум: " + MaxFinder.findMax(numbers)); // 5

        System.out.println("\nТест 2: Строки (String)");
        String[] words = {"apple", "banana", "cherry"};
        System.out.println("Массив: " + Arrays.toString(words));
        System.out.println("Максимум: " + MaxFinder.findMax(words)); // "cherry"

        System.out.println("\nТест 3: Вещественные числа (Double)");
        Double[] doubles = {3.14, 2.71, 1.41, 1.62};
        System.out.println("Массив: " + Arrays.toString(doubles));
        System.out.println("Максимум: " + MaxFinder.findMax(doubles)); // 3.14

        System.out.println("\nТест 4: Символы (Character)");
        Character[] chars = {'a', 'z', 'm', 'b'};
        System.out.println("Массив: " + Arrays.toString(chars));
        System.out.println("Максимум: " + MaxFinder.findMax(chars)); // 'z'
    }
}