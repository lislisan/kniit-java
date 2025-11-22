package org.kniit.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> wordList = new ArrayList<>();
            Scanner fileScanner = new Scanner(new File("misc/dictionary.txt"));
            while (fileScanner.hasNext()) {
                String word = fileScanner.nextLine().trim();
                if (!word.isEmpty()) {
                    wordList.add(word);
                }
            }
            fileScanner.close();

            char[] russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();

            DictionaryStatistic stats = new DictionaryStatistic(
                    wordList.toArray(new String[0]),
                    russianAlphabet
            );

            System.out.println("=== СТАТИСТИКА СЛОВАРЯ ===");
            System.out.println("Общее количество слов: " + stats.getDictionarySize());
            System.out.println("Количество палиндромов: " + stats.getPolindromCount());
            System.out.println("Минимальная длина слова: " + stats.getMinWordLength());
            System.out.println("Максимальная длина слова: " + stats.getMaxWordLength());
            System.out.println();

            stats.printSymbolsStat();
            System.out.println();

            System.out.println("Случайное слово из словаря: " + stats.getRandomWord());
            System.out.println();

            playWordGame(stats);

        } catch (FileNotFoundException e) {
            System.out.println("Файл словаря не найден!");
        }
    }

    private static void playWordGame(DictionaryStatistic stats) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("\n ИГРА В СЛОВА ");
        System.out.println("Введите слово:");
        String inputWord = inputScanner.nextLine().trim();

        if (inputWord.isEmpty()) {
            System.out.println("Слово не ввели!");
            return;
        }

        System.out.println("\nСлова, которые можно составить из букв '" + inputWord + "':");

        List<String> possibleWords = stats.findWordsFromLetters(inputWord);

        if (possibleWords.isEmpty()) {
            System.out.println("Не найдено слов, которые можно составить из этих букв.");
        } else {
            Map<Integer, List<String>> wordsByLength = new TreeMap<>(Collections.reverseOrder());
            for (String word : possibleWords) {
                int length = word.length();
                wordsByLength.computeIfAbsent(length, k -> new ArrayList<>()).add(word);
            }

            for (Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
                System.out.println(entry.getKey() + " букв: " + String.join(", ", entry.getValue()));
            }

            System.out.println("\nВсего найдено слов: " + possibleWords.size());
        }

        inputScanner.close();
    }
}