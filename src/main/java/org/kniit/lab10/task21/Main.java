package org.kniit.lab10.task21;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тест 1: Фильтрация строк");

        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry", "apricot");

        List<String> startsWithA = FilterExample.filter(words, s -> s.startsWith("a"));
        System.out.println("Слова на 'a': " + startsWithA);

        List<String> containsErry = FilterExample.filter(words, s -> s.contains("erry"));
        System.out.println("Содержат 'erry': " + containsErry);

        List<String> longerThan5 = FilterExample.filter(words, s -> s.length() > 5);
        System.out.println("Длиннее 5 символов: " + longerThan5);

        System.out.println("\nТест 2: Фильтрация чисел");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = FilterExample.filter(numbers, n -> n % 2 == 0);
        System.out.println("Четные: " + evenNumbers);

        List<Integer> greaterThan5 = FilterExample.filter(numbers, n -> n > 5);
        System.out.println("Больше 5: " + greaterThan5);
    }
}