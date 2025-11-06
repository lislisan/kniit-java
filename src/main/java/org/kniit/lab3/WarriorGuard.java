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
            int now_damage = Math.max(value - (this.getDefense() + additionalDefence), 0);
            int new_health = this.getNow_Health() - now_damage;
            System.out.println(this.getName() + " полученный урон уменьшен. Щит! 🛡️");
            super.minus_health(value - additionalDefence);
        }
    }

}
