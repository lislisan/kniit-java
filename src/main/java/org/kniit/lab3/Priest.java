package org.kniit.lab3;

public class Priest extends Player implements Healer {
    private int healPower = 20;
    private int healRange = 6;

    public Priest(String name){
        super(name, 100, 10, 8, 3);
    }

    @Override
    public void heal(Player player) {
        if (this.getAlive()) {
            if (!player.getAlive()) {
                System.out.println(this.getName() + " не может исцелить мертвого " + player.getName() + "! ☠️");
                return;
            }

            double distance = this.calculateDistance(player);
            if (distance <= healRange) {
                System.out.println(this.getName() + " исцеляет " + player.getName() + " 💚");
                player.plus_health(healPower);
            } else {
                System.out.println(this.getName() + " не достает для исцеления " + player.getName() + "! 📏");
                System.out.println("Расстояние: " + String.format("%.1f", distance) +
                        ", а дальность лечения: " + healRange);
            }
        } else {
            System.out.println(this.getName() + " мёртв и не может исцелять ☠️");
        }
    }
}
