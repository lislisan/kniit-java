package org.kniit.lab3;

public class Player {
    private String name;
    private int now_health;
    private int max_health;
    private boolean alive;
    private int x_position;
    private int y_position;
    private int damage;
    private int defense;
    private int attackRange;

    public Player(String name, int max_health, int damage, int defense, int attackRange){
        this.name = name;
        this.now_health = max_health;
        this.max_health = max_health;
        this.alive = true;
        this.x_position = 0;
        this.y_position = 0;
        this.damage = damage;
        this.defense = defense;
        this.attackRange = attackRange;
    }

    public String getName(){
        return name;
    }

    public int getNow_Health(){
        return now_health;
    }

    public boolean getAlive(){
        return alive;
    }

    public int getX_position(){
        return x_position;
    }

    public int getY_position(){
        return y_position;
    }

    public int getDefense(){
        return defense;
    }

    public int getDamage(){
        return damage;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setPosition(int x, int y) {
        this.x_position = x;
        this.y_position = y;
    }

    public void plus_health(int value){
        if (alive){
            now_health = Math.min(value + now_health, max_health);
            System.out.println(name + " получил лечение 💊. Здоровье: " + now_health);
        }
        else {
            System.out.println(name + " мёртв ☠️");
        }
    }

    public void minus_health(int value){
        if (alive){
            int actualDamage = Math.max(value - defense, 1);
            now_health = now_health - actualDamage;
            if (now_health > 0){
                System.out.println(name + " получил урон 🔪. Здоровье: " + now_health);
            }
            if (now_health <= 0){
                now_health = 0;
                System.out.println(name + " погиб. Светлая память ему 🕊️");
                alive = false;
            }
        }
        else{
            System.out.println(name + " мёртв. Лежачих не бьют 😢");
        }
    }

    public void move(int pos_X, int pos_Y){
        if (alive){
            this.x_position = pos_X;
            this.y_position = pos_Y;
            System.out.println(name + " переместился. Текцущая позиция: " + x_position + "; " + y_position);
        }
        else{
            System.out.println("Мертвецы не ходят 🧟‍♂️");
        }
    }


    public double calculateDistance(Player other) {
        int dx = this.x_position - other.getX_position();
        int dy = this.y_position - other.getY_position();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean canAttack(Player target) {
        double distance = calculateDistance(target);
        return distance <= this.attackRange;
    }

    @Override
    public String toString(){
        return String.format("Имя: %s | Класс: %s | Здоровье: %d/%d | Статус: %s | Позиция: (%d, %d) | Урон: %d | Защита: %d",
                name, this.getClass().getSimpleName(), now_health, max_health, alive ? "Жив" : "Мёртв", x_position, y_position, damage, defense);
    }
}
