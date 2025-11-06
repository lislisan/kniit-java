package org.kniit.lab3;

public class Mage extends Player implements MagAttack {
    public Mage(String name){
        super(name, 80, 35, 5);
    }

    public void magattack(Player player){
        if (this.getAlive()){
            System.out.println(this.getName() + "накладывает заклинание на " + player.getName() + " 🪄✨");
            player.minus_health(this.getDamage());
        }
        else {
            System.out.println(this.getName() + " мёртв и не может использовать заклинания ☠️");
        }
    }


}
