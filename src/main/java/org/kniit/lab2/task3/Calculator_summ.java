package org.kniit.lab2.task3;

public class Calculator_summ {
    public static void SummNum(String num1, String num2) {
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        int result = a + b;
        System.out.println(result);
    }
    public static void MinusNum(String num1, String num2) {
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        int result = a - b;
        System.out.println(result);
    }
    public static void MultiNum(String num1, String num2) {
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        int result = a * b;
        System.out.println(result);
    }
    public static void DellNum(String num1, String num2) {
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        if(b == 0) {
            System.out.println("Ошибка => Деление на 0");
            return;
        }
        int result = a / b;
        System.out.println(result);
    }
}
