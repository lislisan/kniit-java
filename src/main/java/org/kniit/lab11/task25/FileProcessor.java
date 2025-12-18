package org.kniit.lab11.task25;

import java.io.*;
import java.util.List;

public class FileProcessor {
    private FileDAO fileDAO = new FileDAO();

    public void processFiles(String path) {
        File fileOrDir = new File(path);

        if (!fileOrDir.exists()) {
            System.out.println("❌ Путь не существует: " + path);
            return;
        }

        try {
            if (fileOrDir.isFile()) {
                fileDAO.saveFile(fileOrDir);
            } else if (fileOrDir.isDirectory()) {
                File[] files = fileOrDir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            try {
                                fileDAO.saveFile(file);
                            } catch (IOException e) {
                                System.out.println("⏭️ Пропущен " + file.getName() + ": " + e.getMessage());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Ошибка: " + e.getMessage());
        }
    }

    public void listFiles() {
        try {
            List<FileInfo> files = fileDAO.listFiles();
            if (files.isEmpty()) {
                System.out.println("📂 Файлов нет");
            } else {
                System.out.println("📋 Список файлов:");
                files.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("❌ Ошибка: " + e.getMessage());
        }
    }

    public void saveLocalFile(int id) {
        try {
            byte[] fileBytes = fileDAO.getFileById(id);
            if (fileBytes == null) {
                System.out.println("❌ Файл с ID " + id + " не найден");
                return;
            }

            String fileName = "extracted_file_" + id;
            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                fos.write(fileBytes);
            }
            System.out.println("💾 Файл сохранен: " + fileName);
        } catch (Exception e) {
            System.out.println("❌ Ошибка: " + e.getMessage());
        }
    }
}
