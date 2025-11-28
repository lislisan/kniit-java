package org.kniit.lab5.task_9;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameStats {
    private int colWords;
    private List<String> correctWords;
    private int wrongWords;
    private long startsGameTime;
    private long endGameTime;
    private int simvols;

    public GameStats(List<String> words, long startTime){
        this.colWords = 0;
        this.correctWords = words;
        this.wrongWords = 0;
        this.startsGameTime = System.currentTimeMillis();
        this.simvols = 0;
        calculateStatistic();
    }

    public int getColWords(){
        return colWords;
    }

    public int getWrongWords(){
        return wrongWords;
    }

    public int getCorrectWords(){
        return colWords - wrongWords;
    }

    public int getSimvols(){
        return simvols;
    }

    private void calculateStatistic(){
        long currentTime;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            currentTime = System.currentTimeMillis();
            long elapsedSeconds = (currentTime - startsGameTime) / 1000;

            if (elapsedSeconds >= 60){
                System.out.println("Время вышло!!");
                break;
            }
            String targetWord = correctWords.get(random.nextInt(correctWords.size()));
            System.out.println("Напечатайте: " + targetWord);
            System.out.print("Ввод: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }
            colWords++;
            if (correctWords.contains(input)) {
                System.out.println("✓ Правильно!");
                simvols += input.length();
            } else {
                wrongWords++;
                System.out.println("Х Неверно!");
                simvols += input.length();
            }
        }
    }
}
