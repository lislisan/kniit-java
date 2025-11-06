package org.kniit.lab3;

public class Warrior extends Player implements Attacker {

    public Warrior(String name){
        super(name, 150, 25, 15, 2);
    }

    @Override
    public void attack(Player player){
        if (this.getAlive()){
            if (!player.getAlive()) {
                System.out.println(this.getName() + " не может атаковать мертвого " + player.getName() + "! ☠️");
                return;
            }

            if (this.canAttack(player)) {
                System.out.println(this.getName() + " яростно атакует мечом ⚔️ " + player.getName() + "!");
                player.minus_health(this.getDamage());
            } else {
                System.out.println(this.getName() + " не достает до " + player.getName() + "! 📏");
                System.out.println("Расстояние: " + String.format("%.1f", this.calculateDistance(player)) +
                        ", а дальность атаки: " + this.getAttackRange());
            }
        }
        else{
            System.out.println(this.getName() + " мертв и не может атаковать. ☠️");
        }
    }

}
