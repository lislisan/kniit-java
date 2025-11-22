package org.kniit.lab4;
import java.util.*;
//реализуйте его методы
//добавляйте свои методы при необходимости

class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов
    private int polindrom; // Количество слов полиндромов
    private int maxWordLength; // максимальная длина слова в словаре
    private int minWordLength; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита
    private int[] frequency; // частота букв в словаре

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.dictionarySize = words.length;
        calculateStatistics();
    }

    private void calculateStatistics() {
        calculateWordLengths();
        calculatePalindromes();
        calculateFrequency();
    }

    private void calculateWordLengths() {
        if (words.length == 0) {
            minWordLength = 0;
            maxWordLength = 0;
            return;
        }

        minWordLength = words[0].length();
        maxWordLength = words[0].length();

        for (String word : words) {
            int length = word.length();
            if (length < minWordLength) {
                minWordLength = length;
            }
            if (length > maxWordLength) {
                maxWordLength = length;
            }
        }
    }

    private void calculatePalindromes() {
        polindrom = 0;
        for (String word : words) {
            if (isPalindrome(word)) {
                polindrom++;
            }
        }
    }

    private boolean isPalindrome(String word) {
        String cleanWord = word.toLowerCase().replaceAll("[^а-яА-Я]", "");
        int left = 0;
        int right = cleanWord.length() - 1;

        while (left < right) {
            if (cleanWord.charAt(left) != cleanWord.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void calculateFrequency() {
        frequency = new int[alphabet.length];

        for (String word : words) {
            String lowerWord = word.toLowerCase();
            for (char c : lowerWord.toCharArray()) {
                int index = indexOfChar(c);
                if (index != -1) {
                    frequency[index]++;
                }
            }
        }
    }

    private int indexOfChar(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public String getRandomWord() {
        if (words.length == 0) {
            return "";
        }
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    public void printSymbolsStat() {
        System.out.println("Статистика букв в словаре:");
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + " - " + frequency[i]);
        }
    }

    public int getDictionarySize() {
        return dictionarySize;
    }

    public int getPolindromCount() {
        return polindrom;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

    public List<String> findWordsFromLetters(String inputWord) {
        List<String> result = new ArrayList<>();
        String lowerInput = inputWord.toLowerCase();
        Map<Character, Integer> inputFreq = getFrequencyMap(lowerInput);

        for (String word : words) {
            String lowerWord = word.toLowerCase();
            Map<Character, Integer> wordFreq = getFrequencyMap(lowerWord);
            if (canFormWord(inputFreq, wordFreq)) {
                result.add(word);
            }
        }

        result.sort((a, b) -> Integer.compare(b.length(), a.length()));
        return result;
    }

    private Map<Character, Integer> getFrequencyMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    private boolean canFormWord(Map<Character, Integer> available, Map<Character, Integer> required) {
        for (Map.Entry<Character, Integer> entry : required.entrySet()) {
            char c = entry.getKey();
            int requiredCount = entry.getValue();
            int availableCount = available.getOrDefault(c, 0);

            if (requiredCount > availableCount) {
                return false;
            }
        }
        return true;
    }
}