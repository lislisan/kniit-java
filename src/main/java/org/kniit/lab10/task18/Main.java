package org.kniit.lab10.task18;

public class Main {
    public static void main(String[] args) {
        System.out.println("Пример 1: String и Integer:");
        Pair<String, Integer> agePair = new Pair<>("Возраст", 30);
        System.out.println(agePair.getFirst());
        System.out.println(agePair.getSecond());

        agePair.setSecond(35);
        System.out.println("После изменения: " + agePair.getSecond());

        System.out.println("\nПример 2: String и String:");
        Pair<String, String> namePair = new Pair<>("Имя", "Анна");
        System.out.println(namePair.getFirst() + ": " + namePair.getSecond());

        System.out.println("\nПример 3: Integer и Double:");
        Pair<Integer, Double> coordinates = new Pair<>(10, 20.5);
        System.out.println("X: " + coordinates.getFirst());
        System.out.println("Y: " + coordinates.getSecond());

        System.out.println("\nПример 4: Разные типы:");
        Pair<String, Boolean> status = new Pair<>("Активен", true);
        System.out.println(status.toString());

        System.out.println("\nПример 5: Изменение обоих значений:");
        Pair<String, Integer> person = new Pair<>("Иван", 25);
        System.out.println("До: " + person);
        person.setFirst("Мария");
        person.setSecond(30);
        System.out.println("После: " + person);
    }
}