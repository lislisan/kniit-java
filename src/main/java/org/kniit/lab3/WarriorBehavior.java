package org.kniit.lab3;

public class WarriorBehavior implements ClassBehavior, Attacker {
    protected int attackPower;
    protected int attackRange;

    public WarriorBehavior() {
        this.attackPower = 20;
        this.attackRange = 2;
    }

    @Override
    public void performAction(Player target) {
        attack(target);
    }

    @Override
    public void attack(Player target) {
        System.out.println("Атакует врага!");
        target.decreaseHealth(attackPower);
    }

    @Override
    public String getClassName() {
        return "Воин";
    }

    @Override
    public int getActionPower() {
        return attackPower;
    }

    public int getAttackRange() {
        return attackRange;
    }
}