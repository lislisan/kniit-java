package org.kniit.lab3;

public class WarriorGuard extends Warrior {
    private int additionalDefence;

    public WarriorGuard(String name) {
        super(name);
        this.additionalDefence = 10;
    }

    @Override
    public void minus_health(int value) {
        if (this.getAlive()){
            int actualDamage = Math.max(value - (this.getDefense() + additionalDefence), 1);
            System.out.println(this.getName() + " блокирует часть урона щитом! 🛡️ (Защита: " +
                    this.getDefense() + " + " + additionalDefence + " бонус)");
            super.minus_health(value - additionalDefence);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [Гвардия]";
    }

}
