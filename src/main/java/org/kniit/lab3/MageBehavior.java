package org.kniit.lab3;

public class MageBehavior implements ClassBehavior, SpellCaster {
    private int spellPower;

    public MageBehavior() {
        this.spellPower = 25;
    }

    @Override
    public void performAction(Player target) {
        castSpell(target);
    }

    @Override
    public void castSpell(Player target) {
        System.out.println("Кастует магическое заклинание!");
        target.decreaseHealth(spellPower);
    }

    @Override
    public String getClassName() {
        return "Маг";
    }

    @Override
    public int getActionPower() {
        return spellPower;
    }
}