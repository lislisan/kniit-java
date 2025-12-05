package org.kniit.lab7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFileVisitor {
    public static void main(String[] args) {
        String folderPath = "/Users/elizavetaandreeva/Kniit-java/FolderForLab7";

        try {
            long totalWords = countWordsInTextFiles(folderPath);
            System.out.println("Общее количество слов во всех текстовых файлах: " + totalWords);
        } catch (IOException e) {
            System.err.println("Ошибка при обработке файлов");
        }
    }

    public static long countWordsInTextFiles(String folderPath) throws IOException {
        Path startPath = Paths.get(folderPath);

        WordCountVisitor visitor = new WordCountVisitor();
        Files.walkFileTree(startPath, visitor);

        return visitor.getTotalWordCount();
    }
}