package org.kniit.lab3;

public class Race {
    private String name;
    private int attackBonus;
    private int defenseBonus;
    private int healingBonus;
    private int spellBonus;

    public Race(String name, int attackBonus, int defenseBonus, int healingBonus, int spellBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.healingBonus = healingBonus;
        this.spellBonus = spellBonus;
    }

    public String getName() { return name; }
    public int getAttackBonus() { return attackBonus; }
    public int getDefenseBonus() { return defenseBonus; }
    public int getHealingBonus() { return healingBonus; }
    public int getSpellBonus() { return spellBonus; }

    public static final Race HUMAN = new Race("Человек", 2, 2, 2, 2);
    public static final Race ELF = new Race("Эльф", 1, 1, 3, 4);
    public static final Race ORC = new Race("Орк", 4, 3, 0, 0);
    public static final Race DWARF = new Race("Дворф", 3, 4, 1, 0);
}