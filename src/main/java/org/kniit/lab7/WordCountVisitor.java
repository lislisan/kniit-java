package org.kniit.lab7;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Pattern;

public class WordCountVisitor extends SimpleFileVisitor<Path> {
    private long totalWordCount = 0;
    private static final Pattern TXT_PATTERN = Pattern.compile(".*\\.txt$", Pattern.CASE_INSENSITIVE);

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (isTextFile(file)) {
            long wordCount = countWordsInFile(file);
            System.out.println("Файл: " + file.getFileName() + " - слов: " + wordCount);
            totalWordCount += wordCount;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println("Не удалось прочитать файл: " + file + " - " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Обработка папки: " + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }

    private boolean isTextFile(Path file) {
        String fileName = file.getFileName().toString();
        return TXT_PATTERN.matcher(fileName).matches();
    }

    private long countWordsInFile(Path file) throws IOException {
        try {
            String content = Files.readString(file);
            String[] words = content.split("\\s+"); // по пробелам, табуляции, переносам строк

            if (words.length == 1 && words[0].isEmpty()) {
                return 0;
            }

            return words.length;
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла " + file + ": " + e.getMessage());
            return 0;
        }
    }

    public long getTotalWordCount() {
        return totalWordCount;
    }
}