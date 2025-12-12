package org.kniit.lab9.task15;

public class Task15 {
    enum Season {
        WINTER("Холодно", "Новый год"),
        SPRING("Тепло", "Пасха"),
        SUMMER("Жарко", "День России"),
        AUTUMN("Прохладно", "День учителя");

        final String temp;
        final String holiday;

        Season(String temp, String holiday) {
            this.temp = temp;
            this.holiday = holiday;
        }
    }

    public static void main(String[] args) {
        System.out.println("Времена года:");
        for (Season s : Season.values()) {
            String name = "";
            switch(s) {
                case WINTER: name = "Зима"; break;
                case SPRING: name = "Весна"; break;
                case SUMMER: name = "Лето"; break;
                case AUTUMN: name = "Осень"; break;
            }

            System.out.println(name + ": " + s.temp +
                    ", типичный праздник - " + s.holiday);
        }
    }
}