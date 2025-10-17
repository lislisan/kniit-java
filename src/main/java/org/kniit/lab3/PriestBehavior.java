package org.kniit.lab3;

public class PriestBehavior implements ClassBehavior, Healer {
    private int healPower;

    public PriestBehavior() {
        this.healPower = 30;
    }

    @Override
    public void performAction(Player target) {
        heal(target);
    }

    @Override
    public void heal(Player target) {
        System.out.println("Исцеляет цель!");
        target.increaseHealth(healPower);
    }

    @Override
    public String getClassName() {
        return "Жрец";
    }

    @Override
    public int getActionPower() {
        return healPower;
    }
}