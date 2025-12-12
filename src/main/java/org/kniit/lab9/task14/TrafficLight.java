package org.kniit.lab9.task14;

import java.util.Scanner;

public class TrafficLight {
    enum TrafficLights {
        RED {
            public String getNext() { return "GREEN"; }
            public String getRussian() { return "Красный"; }
        },
        YELLOW {
            public String getNext() { return "RED"; }
            public String getRussian() { return "Желтый"; }
        },
        GREEN {
            public String getNext() { return "YELLOW"; }
            public String getRussian() { return "Зеленый"; }
        };

        public abstract String getNext();
        public abstract String getRussian();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Сигналы светофора: RED, YELLOW, GREEN");

        while (true) {
            System.out.print("\nВведите сигнал (или 'выход'): ");
            String input = sc.nextLine().toUpperCase();

            if (input.equals("ВЫХОД") || input.equals("EXIT")) {
                break;
            }

            try {
                TrafficLights light = TrafficLights.valueOf(input);
                System.out.println("Текущий: " + light.getRussian());
                System.out.println("Следующий: " + light.getNext());
            } catch (Exception e) {
                System.out.println("Ошибка! Введите RED, YELLOW или GREEN");
            }
        }

        sc.close();
        System.out.println("Программа завершена.");
    }
}