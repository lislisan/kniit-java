package org.kniit.lab3;

public class Mage extends Player implements MagAttack {
    private int spellPower = 35;

    public Mage(String name){
        super(name, 80, 35, 5, 8);
    }

    public void magattack(Player player){
        if (this.getAlive()){
            if (!player.getAlive()) {
                System.out.println(this.getName() + " не может атаковать мертвого " + player.getName() + "! ☠️");
                return;
            }

            if (this.canAttack(player)) {
                System.out.println(this.getName() + " читает заклинание огня 🔥 на " + player.getName() + "!");
                player.minus_health(spellPower);
            } else {
                System.out.println(this.getName() + " не достает до " + player.getName() + "! 📏");
                System.out.println("Расстояние: " + String.format("%.1f", this.calculateDistance(player)) +
                        ", а дальность атаки: " + this.getAttackRange());
            }
        }
        else{
            System.out.println(this.getName() + " мертв и не может кастовать заклинания. ☠️");
        }
    }
}
