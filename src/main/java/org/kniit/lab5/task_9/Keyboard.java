package org.kniit.lab5.task_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Keyboard {
    public static void main(String[] args){
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
            List<String> randomWords = getRandomWords(wordList, 100);
            long startTime = System.currentTimeMillis();
            GameStats statistic = new GameStats(randomWords, startTime);
            Play(statistic);
        } catch (FileNotFoundException e) {
            System.out.println("Файл словаря не найден!");
        }
    }
    public static List<String> getRandomWords(List<String> source, int count) {
        List<String> copy = new ArrayList<>(source);
        Collections.shuffle(copy);
        return copy.subList(0, count);
    }
    public static void Play(GameStats statistic){
        System.out.println("    Итог:   ");
        System.out.println("Всего введено слов: " + statistic.getColWords());
        System.out.println("Правильных слов: " + statistic.getCorrectWords());
        System.out.println("Ошибок: " + statistic.getWrongWords());
        System.out.println("Кол-во введенных символов: " + statistic.getSimvols());
    }

}
