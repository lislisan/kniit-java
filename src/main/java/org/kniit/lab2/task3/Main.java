package org.kniit.lab2.task3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== КОНСОЛЬНЫЙ КАЛЬКУЛЯТОР ===");
        Scanner in = new Scanner(System.in);
        String in2 = "Выход";
        System.out.println("Для завершения введите 'Выход'");
        while(true) {
            System.out.print("Ввод: ");
            String in1 = in.nextLine();
            if(in1.equals(in2)) {
                break;
            }
            else {
                Calculator.PrepareString(in1);
            }
        }
    }
}
