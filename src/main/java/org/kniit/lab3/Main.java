package org.kniit.lab3;

public class Main {
    public static void main(String[] args){
        Player strong_man = new WarriorGuard("Стронг мэн");
        Player human_mag = new Mage("Кокоми");
        Player healer = new Priest("Святоша");

        System.out.println("⭕️ Начало игры ⭕️");
        strong_man.setPosition(0, 0);
        human_mag.setPosition(5, 0);
        healer.setPosition(1, 1);

        strong_man.setPosition(0, 0);
        human_mag.setPosition(5, 0);
        healer.setPosition(1, 1);

        System.out.println("\n❗️Начало боя ❗️");
        ((Warrior) strong_man).attack(human_mag);
        ((Priest) healer).heal(human_mag);
        ((Mage) human_mag).magattack(strong_man);
        ((Warrior) strong_man).attack(healer);

        System.out.println("\n--- Перемещение персонажей ---");
        healer.move(4, 0);

        ((Priest) healer).heal(human_mag);

        System.out.println();
        System.out.println("⛔️ Окончание боя ⛔️");
        System.out.println(strong_man);
        System.out.println(human_mag);
        System.out.println(healer);
    }
}
