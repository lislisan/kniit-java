package org.kniit.lab6.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class GuessingWord {
    public static void main(String[] args){
        try {
            List<String> words = new ArrayList<>();
            Scanner fileScan = new Scanner(new File("misc/dictionary.txt"));
            while(fileScan.hasNext()){
                String word = fileScan.nextLine().trim();
                if(!word.isEmpty() && word.length() >= 4){
                    words.add(word);
                }
            }
            fileScan.close();

            Random rand = new Random();
            int randomIndex = rand.nextInt(words.size());
            String coolWord = words.get(randomIndex);
            PlayGame(coolWord);
            System.out.println("Конец!");
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден.");
        }

    }

    public static void PlayGame(String coolWord){
        System.out.println("Игра началась!\nЗагадано слово.");

        coolWord = coolWord.toLowerCase();
        int maxAttempts = 6;
        int attemptsLeft = maxAttempts;

        Set<Character> guessedLetters = new HashSet<>();
        Set<Character> wordLetters = coolWord.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        Scanner scanner = new Scanner(System.in);

        while(attemptsLeft > 0) {
            String currentState = getCurrentState(coolWord, guessedLetters);
            System.out.println("слово: " + currentState);
            System.out.println("Угаданные буквы: " + guessedLetters);
            System.out.println("Осталось попыток: " + attemptsLeft);

            if(currentState.equals(coolWord)) {
                System.out.println("Угадано!" + coolWord);
                return;
            }

            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if(input.length() != 1) {
                System.out.println("Вводите только букву");
                continue;
            }

            char letter = input.charAt(0);

            if(guessedLetters.contains(letter)) {
                System.out.println("Эту букву уже вводили");
                continue;
            }

            guessedLetters.add(letter);

            if(wordLetters.contains(letter)) {
                System.out.println("✅ Буква '" + letter + "' есть в слове.");
            } else {
                attemptsLeft--;
                System.out.println("❌ Буквы '" + letter + "' нет в слове.");
                System.out.println("❕Осталось попыток: " + attemptsLeft);

                printHangman(maxAttempts - attemptsLeft);
            }
        }

        if(attemptsLeft == 0) {
            System.out.println("Вы проиграли! Загаданное слово было: " + coolWord);
        }

        scanner.close();
    }

    private static String getCurrentState(String word, Set<Character> guessedLetters) {
        StringBuilder state = new StringBuilder();
        for(char c : word.toCharArray()) {
            if(guessedLetters.contains(c)) {
                state.append(c).append(" ");
            } else {
                state.append("_ ");
            }
        }
        return state.toString().trim();
    }

    private static void printHangman(int wrongAttempts) {
        String[] hangmanStates = {"☠️❗️", "☠️❗️", "☠️❗️", "☠️❗️", "☠️❗️", "☠️❗️", "☠️❗️"};
        System.out.println(hangmanStates[wrongAttempts]);
    }
}