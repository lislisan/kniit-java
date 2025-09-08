package org.kniit.lab2.task3;

import org.kniit.lab1.task2.Calculator_summ;

public class Calculator {
    public static void PrepareString(String strr) {
        String[] parts = strr.split(" ");
        if(parts.length != 3) {
          System.out.println("Ошибка => Неправильный формат ввода!");
          return;
        }
        String a = parts[0];
        String b = parts[2];
        String sign = parts[1];
        String summ = "+";
        String minus = "-";
        String proiz = "*";
        String dell = "/";
        if(sign.equals(summ)) {
            Calculator_summ.SummNum(a, b);
        }
        else if(sign.equals(minus)) {
            Calculator_summ.MinusNum(a, b);
        }
        else if(sign.equals(proiz)) {
            Calculator_summ.MultiNum(a, b);
        }
        else if(sign.equals(dell)) {
            Calculator_summ.DellNum(a, b);
        }
    }
}
