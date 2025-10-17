package org.kniit.lab3;

public class RPGGame {
    public static void main(String[] args) {
        System.out.println("=== СОЗДАНИЕ ПЕРСОНАЖЕЙ RPG ===\n");

        Player player1 = new Player("Сторож", Race.ORC, new WarriorGuardBehavior());

        Player player2 = new Player("Кокоми", Race.ELF, new MageBehavior());

        Player player3 = new Player("Геральт из Ривии", Race.HUMAN, new PriestBehavior());

        Player player4 = new Player("Тирион Ланнистер", Race.DWARF, new WarriorBehavior());

        System.out.println("СОЗДАННЫЕ ПЕРСОНАЖИ:");
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(player4);
        System.out.println();

        System.out.println("РАССТАНОВКА НА ПОЛЕ БОЯ:");
        player1.move(0, 0);
        player2.move(0, 1);
        player3.move(2, 0);
        player4.move(2, 1);

        System.out.println("\n=== 🔻 НАЧАЛО БОЯ 🔻 ===\n");

        System.out.println(" ➤ РАУНД 1:");
        player1.performClassAction(player2);
        player3.performClassAction(player2);
        player4.performClassAction(player1);

        System.out.println("\n ➤  ➤ РАУНД 2:");
        player2.performClassAction(player1);
        player1.performClassAction(player4);

        player2.move(1, 5);
        player1.performClassAction(player2);

        System.out.println("\n=== ФИНАЛЬНОЕ СОСТОЯНИЕ ===");
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(player4);
    }
}