package org.kniit.lab1.task1;

public class SolutionFirst {
    public static void PrintNumbers() {
        int k = 0;
        String line = "";
        for (int i = 1; i <= 101; i++) {
            if(k<10){
                line = line + i + ", ";
            }
            else {
                System.out.println(line);
                line = i + ", ";
                k = 0;
            }
            k = k + 1;
        }
    }
}
