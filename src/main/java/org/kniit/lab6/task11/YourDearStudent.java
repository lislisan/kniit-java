package org.kniit.lab6.task11;

import java.util.TreeSet;
import java.util.Scanner;

public class YourDearStudent {
    public static void main(String[] args) {
        TreeSet students = new TreeSet<>();
        System.out.println("1. Добавить студента\n2. Удалить студента\n3. Показать всех студентов\n4. Найти студента по имени\n5. Выйти из программы");
        Scanner scanner = new Scanner(System.in);

        while (true) {

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("5") || input.equalsIgnoreCase("Выход")) {
                System.out.println("Программа завершена. До свидания!");
                break;
            }
            try {
                int choice = Integer.parseInt(input);
                PointsOfMenu menuProcessor = new PointsOfMenu(choice, students, scanner);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число от 1 до 5!");
            }
        }
        scanner.close();
    }
}
