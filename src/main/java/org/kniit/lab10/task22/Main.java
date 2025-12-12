package org.kniit.lab10.task22;

public class Main {
    public static void main(String[] args) {
        System.out.println("✔️Тест 1: Базовые операции");
        Dictionary<String, Integer> ages = new Dictionary<>();

        ages.put("Анна", 25);
        ages.put("Иван", 30);
        ages.put("Мария", 22);

        System.out.println("Словарь: " + ages);
        System.out.println("Размер: " + ages.size());
        System.out.println("Возраст Анны: " + ages.get("Анна"));
        System.out.println("Есть ли Иван? " + ages.containsKey("Иван"));
        System.out.println("Есть ли возраст 22? " + ages.containsValue(22));

        System.out.println("\n✔️Тест 2: Обновление и удаление");

        Integer oldAge = ages.put("Анна", 26);
        System.out.println("Старый возраст Анны: " + oldAge);
        System.out.println("Новый возраст Анны: " + ages.get("Анна"));

        Integer removed = ages.remove("Иван");
        System.out.println("Удалили Ивана: " + removed);
        System.out.println("Словарь после удаления: " + ages);
        System.out.println("Есть ли Иван теперь? " + ages.containsKey("Иван"));

        System.out.println("\n✔️Тест 3: Разные типы данных");
        Dictionary<Integer, String> products = new Dictionary<>();
        products.put(1, "Яблоко");
        products.put(2, "Банан");
        products.put(3, "Апельсин");

        System.out.println("Товары: " + products);
        System.out.println("Товар с кодом 2: " + products.get(2));

        Dictionary<String, String> translations = new Dictionary<>();
        translations.put("apple", "яблоко");
        translations.put("banana", "банан");
        translations.put("cherry", "вишня");

        System.out.println("Переводы: " + translations);

        System.out.println("\n✔️Тест 4: Дополнительные методы");
        Dictionary<String, Integer> scores = new Dictionary<>();
        scores.put("Анна", 100);

        scores.putIfAbsent("Анна", 200); // Не изменится
        scores.putIfAbsent("Иван", 150); // Добавится
        System.out.println("putIfAbsent: " + scores);

        System.out.println("Оценка Марии: " + scores.getOrDefault("Мария", 0));

        scores.replace("Иван", 180);
        System.out.println("После replace: " + scores);

    }
}