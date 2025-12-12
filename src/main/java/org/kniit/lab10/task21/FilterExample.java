package org.kniit.lab10.task21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterExample {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {

        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }

        if (predicate == null) {
            throw new IllegalArgumentException("Предикат не может быть null");
        }

        if (list.isEmpty()) {
            return new ArrayList<>();
        }

        List<T> result = new ArrayList<>();

        for (T element : list) {
            if (element == null) {
                continue;
            }

            if (predicate.test(element)) {
                result.add(element);
            }
        }

        return result;
    }
}