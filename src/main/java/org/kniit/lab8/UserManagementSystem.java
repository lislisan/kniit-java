package org.kniit.lab8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagementSystem {
    private static final String FILE_NAME = "users.ser";
    private static List<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в систему управления пользователями!");

        loadUsers(); // загрузка пользователей

        boolean running = true;
        System.out.println("\n=== МЕНЮ ===");
        System.out.println("1. Добавить нового пользователя");
        System.out.println("2. Показать всех пользователей");
        System.out.println("3. Сохранить список пользователей");
        System.out.println("4. Выйти (с автоматическим сохранением)");
        System.out.print("Выберите действие: ");
        while (running) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addNewUser();
                    break;
                case "2":
                    showAllUsers();
                    break;
                case "3":
                    saveUsers();
                    break;
                case "4":
                    saveUsers(); // перед выходом
                    System.out.println("Данные сохранены. До свидания!");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Введите 1-4.");
            }
        }
        scanner.close();
    }

    private static void addNewUser() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        users.add(new User(name, age, email));
        System.out.println("Пользователь добавлен!");
    }

    private static void showAllUsers() {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
            return;
        }

        System.out.println("\n=== Список пользователей ===");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i));
        }
        System.out.println("Всего: " + users.size() + " пользователей");
    }

    private static void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
            System.out.println("Данные сохранены в файл: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    private static void loadUsers() {
        File file = new File(FILE_NAME);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            users = (List<User>) ois.readObject();
            System.out.println("Данные загружены. Пользователей: " + users.size());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Создаем новый список.");
            users = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении файла. Создаем новый список.");
            users = new ArrayList<>();
        }
    }
}