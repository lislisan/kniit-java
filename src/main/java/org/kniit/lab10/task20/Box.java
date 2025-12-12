package org.kniit.lab10.task20;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private List<T> numbers;

    public Box() {
        this.numbers = new ArrayList<>();
    }

    public Box(int initialCapacity) {
        this.numbers = new ArrayList<>(initialCapacity);
    }

    public void add(T number) {
        numbers.add(number);
    }

    public double sum() {
        double total = 0.0;

        for (T number : numbers) {
            total += number.doubleValue();
        }

        return total;
    }

    public int size() {
        return numbers.size();
    }

    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    public void clear() {
        numbers.clear();
    }

    public T get(int index) {
        return numbers.get(index);
    }

    @Override
    public String toString() {
        return "Box{" + numbers + "}";
    }

    public double average() {
        if (isEmpty()) {
            throw new IllegalStateException("Контейнер пуст, невозможно вычислить среднее");
        }
        return sum() / size();
    }

    public T max() {
        if (isEmpty()) {
            throw new IllegalStateException("Контейнер пуст");
        }

        T max = numbers.get(0);

        for (T number : numbers) {
            if (number.doubleValue() > max.doubleValue()) {
                max = number;
            }
        }

        return max;
    }

    public T min() {
        if (isEmpty()) {
            throw new IllegalStateException("Контейнер пуст");
        }

        T min = numbers.get(0);

        for (T number : numbers) {
            if (number.doubleValue() < min.doubleValue()) {
                min = number;
            }
        }

        return min;
    }

    public boolean contains(T number) {
        return numbers.contains(number);
    }

    public T remove(int index) {
        return numbers.remove(index);
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) numbers.toArray(new Number[0]);
    }
}