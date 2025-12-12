package org.kniit.lab9.task16;

public class MimiCards{
    enum Suit { КРЕСТИ, ЧЕРВИ, БУБНЫ, ПИКИ }
    enum Rank {
        ДВА, ТРИ, ЧЕТЫРЕ, ПЯТЬ, ШЕСТЬ, СЕМЬ, ВОСЕМЬ,
        ДЕВЯТЬ, ДЕСЯТЬ, ВАЛЕТ, ДАМА, КОРОЛЬ, ТУЗ
    }

    public static void main(String[] args) {
        System.out.println("Колода из 52 карт:\n");

        int count = 0;
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                System.out.printf("%-8s %s\n", s, r);
                count++;
            }
            System.out.println();
        }

        System.out.println("Итого: " + count + " карт");
    }
}
