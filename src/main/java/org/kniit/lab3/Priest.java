package org.kniit.lab3;

public class Priest extends Player implements Healer {
    private int healPower = 20;

    public Priest(String name){
        super(name, 100, 10, 8);
    }

    @Override
    public void heal(Player player){
        if (this.getAlive()){
            System.out.println(this.getName() + " исцеляет " + player.getName() + " 💚");
            player.plus_health(healPower);
        }
        else{
            System.out.println(this.getName() + "мёрт и не может исцелять ☠️");
        }
    }

}
