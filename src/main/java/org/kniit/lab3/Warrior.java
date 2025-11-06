package org.kniit.lab3;

public class Warrior extends Player implements Attacker {

    public Warrior(String name){
        super(name, 150, 25, 15);
    }

    @Override
    public void attack(Player player){
        if (this.getAlive()){
            System.out.println(this.getName() + " атакует " + player.getName() + "!");
            player.minus_health(this.getDamage());
        }
        else{
            System.out.println(this.getName() + " мертв и не может атаковать.");
        }
    }



}
