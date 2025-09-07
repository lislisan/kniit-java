package org.kniit.lab1.task1;

public class SolutionThird {
    public static void PrintNumbers() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int numbers =  i * 10 + j;
                System.out.print(numbers);

                if (j < 10) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
