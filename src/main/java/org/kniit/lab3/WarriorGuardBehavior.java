package org.kniit.lab3;

public class WarriorGuardBehavior extends WarriorBehavior {
    private int additionalDefense;

    public WarriorGuardBehavior() {
        super();
        this.attackPower = 18;
        this.additionalDefense = 10;
    }

    @Override
    public String getClassName() {
        return "Воин-Страж";
    }

    public int getAdditionalDefense() {
        return additionalDefense;
    }
}