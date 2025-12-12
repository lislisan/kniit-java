package org.kniit.lab10.task20;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тест 1: Integer Box");
        Box<Integer> integerBox = new Box<>();
        integerBox.add(10);
        integerBox.add(20);
        integerBox.add(30);
        System.out.println("Содержимое: " + integerBox);
        System.out.println("Сумма: " + integerBox.sum());
        System.out.println("Размер: " + integerBox.size());
        System.out.println("Среднее: " + integerBox.average());
        System.out.println("Максимум: " + integerBox.max());
        System.out.println("Минимум: " + integerBox.min());

        System.out.println("\nТест 2: Double Box");
        Box<Double> doubleBox = new Box<>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        doubleBox.add(3.5);
        System.out.println("Содержимое: " + doubleBox);
        System.out.println("Сумма: " + doubleBox.sum());
        System.out.println("Содержит 2.5? " + doubleBox.contains(2.5));

        System.out.println("\nТест 3: Mixed operations");
        Box<Number> mixedBox = new Box<>();
        mixedBox.add(10);      // Integer (автоупаковка)
        mixedBox.add(3.14);    // Double
        mixedBox.add(2.71f);   // Float
        mixedBox.add(100L);    // Long
        System.out.println("Смешанные числа: " + mixedBox);
        System.out.println("Общая сумма: " + mixedBox.sum());

        System.out.println("\nТест 4: Обработка ошибок");
        Box<Integer> emptyBox = new Box<>();
        System.out.println("Пустой бокс: " + emptyBox);
        System.out.println("Пуст? " + emptyBox.isEmpty());

        try {
            System.out.println("Сумма пустого: " + emptyBox.sum()); // 0.0
            System.out.println("Среднее пустого: " + emptyBox.average()); // Исключение!
        } catch (IllegalStateException e) {
            System.out.println("Поймали ошибку: " + e.getMessage());
        }

        System.out.println("\nТест 5: Удаление элементов");
        Box<Integer> box = new Box<>();
        box.add(1);
        box.add(2);
        box.add(3);
        box.add(4);
        box.add(5);
        System.out.println("До удаления: " + box);
        System.out.println("Удален элемент с индексом 2: " + box.remove(2));
        System.out.println("После удаления: " + box);
        System.out.println("Новая сумма: " + box.sum());
    }
}