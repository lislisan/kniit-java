package org.kniit.lab11.task24;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static UserService userService = new UserService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("User Management System. Commands: add, list, delete, update, exit");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            try {
                processCommand(input);
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void processCommand(String input) throws SQLException {
        String[] parts = input.split("\\s+", 4);
        switch (parts[0].toLowerCase()) {
            case "add":
                if (parts.length == 3) {
                    userService.registerUser(parts[1], parts[2]);
                } else {
                    System.out.println("Usage: add [name] [email]");
                }
                break;
            case "list":
                List<User> users = userService.listAllUsers();
                users.forEach(user ->
                        System.out.println(user.getId() + ": " + user.getName() + " - " + user.getEmail()));
                break;
            case "delete":
                if (parts.length == 2) {
                    userService.deleteUser(Integer.parseInt(parts[1]));
                } else {
                    System.out.println("Usage: delete [id]");
                }
                break;
            case "update":
                if (parts.length == 4) {
                    userService.updateUser(Integer.parseInt(parts[1]), parts[2], parts[3]);
                } else {
                    System.out.println("Usage: update [id] [new_name] [new_email]");
                }
                break;
            default:
                System.out.println("Unknown command");
        }
    }
}
