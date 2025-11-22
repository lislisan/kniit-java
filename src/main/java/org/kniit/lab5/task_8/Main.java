package org.kniit.lab5.task_8;

//Научиться переопределять методы hashcode и equals
//Научиться работать с Comparator

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] names = {"тапочки", "футболка", "кеды", "кепка", "джинсы", "носки", "шарф"};
        String[] categories = {"одежда", "модные вещицы", "трендовые вещи"};

        Random random = new Random();

        ShopItem[] items = new ShopItem[100];

        System.out.println("Генерируем объекты: ");

        for (int i = 0; i < items.length; i++) {
            String name = names[random.nextInt(names.length)];
            double price = 1000 + random.nextDouble() * 900;
            int quantity = 1 + random.nextInt(50);
            String category = categories[random.nextInt(categories.length)];

            items[i] = new ShopItem(name, price, quantity, category);
        }

        System.out.println("\n Неотсортированный массив: ");
        for (int i = 0; i < Math.min(10, items.length); i++) {
            System.out.println(items[i]);
        }

        Arrays.sort(items, new ShopItemComparator());

        System.out.println("\n Отсортирован по имени: ");
        for (int i = 0; i < Math.min(10, items.length); i++) {
            System.out.println(items[i]);
        }

        Arrays.sort(items, new PriceComparator());

        System.out.println("\n Сортируем по цене");
        for (int i = 0; i < Math.min(10, items.length); i++) {
            System.out.println(items[i]);
        }

        System.out.println("\n Считаем объекты");
        countDuplicateItems(items);

        System.out.println("\n Переопределение equals и hashcode");
        demonstrateEqualsAndHashCode();
    }

    private static void countDuplicateItems(ShopItem[] items) {
        Map<ShopItem, Integer> frequencyMap = new HashMap<>();

        for (ShopItem item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        int totalDuplicates = 0;
        for (Map.Entry<ShopItem, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Объект: " + entry.getKey() + " - встречается " + entry.getValue() + " раз(а)");
                totalDuplicates += entry.getValue() - 1;
            }
        }

        System.out.println("Общее количество дубликатов: " + totalDuplicates);
        System.out.println("Уникальных объектов: " + frequencyMap.size());
    }

    private static void demonstrateEqualsAndHashCode() {
        ShopItem item1 = new ShopItem("книга", 50.0, 10, "книги");
        ShopItem item2 = new ShopItem("книга", 50.0, 10, "книги");
        ShopItem item3 = new ShopItem("книга", 60.0, 10, "книги");

        System.out.println("item1: " + item1);
        System.out.println("item2: " + item2);
        System.out.println("item3: " + item3);

        System.out.println("item1.equals(item2): " + item1.equals(item2));
        System.out.println("item1.equals(item3): " + item1.equals(item3));

        System.out.println("item1.hashCode(): " + item1.hashCode());
        System.out.println("item2.hashCode(): " + item2.hashCode());
        System.out.println("item3.hashCode(): " + item3.hashCode());

        System.out.println("item1.hashCode() == item2.hashCode(): " + (item1.hashCode() == item2.hashCode()));
        System.out.println("item1.hashCode() == item3.hashCode(): " + (item1.hashCode() == item3.hashCode()));
    }
}