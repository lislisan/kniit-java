package org.kniit.lab11.task25;

import java.util.Scanner;
//path /Users/elizavetaandreeva/Desktop/test_files
public class FileApp {
    private static FileProcessor processor = new FileProcessor();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Система сохранения файлов в БД ===");
        System.out.println("Команды: path [путь], list, saveLocal [id], exit");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                processor.listFiles();
            } else if (input.startsWith("saveLocal ")) {
                try {
                    int id = Integer.parseInt(input.substring(9).trim());
                    processor.saveLocalFile(id);
                } catch (NumberFormatException e) {
                    System.out.println("❌ Неверный ID");
                }
            } else if (input.startsWith("path ")) {
                String path = input.substring(5).trim();
                processor.processFiles(path);
            } else {
                System.out.println("❌ Неизвестная команда");
            }
        }
        scanner.close();
    }
}
