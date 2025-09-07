package org.kniit.lab1.task1;

public class SolutionSecond {
    public static void PrintNumbers() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i);

            if (i % 10 == 0) {
                System.out.println();
            }
            else {
                System.out.print(", ");
            }
        }
    }
}
