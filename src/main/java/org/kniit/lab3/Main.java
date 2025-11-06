package org.kniit.lab3;

public class Main {
    public static void main(String[] args){
        Player strong_man = new WarriorGuard("Стронг мэн");
        Player human_mag = new Mage("Кокоми");
        Player healer = new Priest("Святоша");

        System.out.println("⭕️ Начало игры ⭕️");
        System.out.println(strong_man);
        System.out.println(human_mag);
        System.out.println(healer);

        System.out.println("❗️Начало боя ❗️");
        ((Warrior) strong_man).attack(human_mag);
        ((Priest) healer).heal(human_mag);
        ((Mage) human_mag).magattack(strong_man);
        ((Warrior) strong_man).attack(healer);

        System.out.println();
        System.out.println("⛔️ Окончание боя ⛔️");
        System.out.println(strong_man);
        System.out.println(human_mag);
        System.out.println(healer);

        System.out.println();
        System.out.println(" ___ Описание классов: ");
    }
}
