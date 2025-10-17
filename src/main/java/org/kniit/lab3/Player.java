package org.kniit.lab3;

public class Player {
    private String name;
    private int currentHealth;
    private int maxHealth;
    private boolean isAlive;
    private int positionX;
    private int positionY;
    private int defense;

    private Race race;
    private ClassBehavior characterClass;

    public Player(String name, Race race, ClassBehavior characterClass) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.isAlive = true;
        this.positionX = 0;
        this.positionY = 0;

        calculateStats();
    }

    private void calculateStats() {
        this.defense = 5;

        if (characterClass instanceof WarriorBehavior) {
            this.maxHealth = 120 + race.getDefenseBonus() * 5;
        } else if (characterClass instanceof MageBehavior) {
            this.maxHealth = 80 + race.getSpellBonus() * 3;
        } else if (characterClass instanceof PriestBehavior) {
            this.maxHealth = 100 + race.getHealingBonus() * 4;
        }

        this.currentHealth = maxHealth;
    }

    public void increaseHealth(int value) {
        if (!isAlive) {
            System.out.println(name + "💀💀💀 мертв и не может быть вылечен!");
            return;
        }

        int actualHeal = value + race.getHealingBonus();
        currentHealth += actualHeal;

        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }

        System.out.println(name + " получил " + actualHeal + " лечения. Здоровье: " + currentHealth + "/" + maxHealth);
    }

    public void decreaseHealth(int value) {
        if (!isAlive) {
            System.out.println(name + " уже мертв! 💀💀💀");
            return;
        }

        int totalDefense = defense + race.getDefenseBonus();

        if (characterClass instanceof WarriorGuardBehavior) {
            WarriorGuardBehavior guard = (WarriorGuardBehavior) characterClass;
            totalDefense += guard.getAdditionalDefense();
        }

        int actualDamage = Math.max(0, value - totalDefense);
        currentHealth -= actualDamage;

        System.out.println(name + " получил " + actualDamage + " урона (защита: " + totalDefense + "). Здоровье: " + currentHealth + "/" + maxHealth);

        if (currentHealth <= 0) {
            currentHealth = 0;
            isAlive = false;
            System.out.println("💀💀💀" + name + " погиб!");
        }
    }

    public void move(int x, int y) {
        if (!isAlive) {
            System.out.println(name + " мертв и не может двигаться!");
            return;
        }

        this.positionX = x;
        this.positionY = y;
        System.out.println("step...step.... " + name + " переместился в позицию (" + x + ", " + y + ")");
    }

    public void performClassAction(Player target) {
        if (!isAlive) {
            System.out.println(name + " мертв и не может действовать!");
            return;
        }

        if (characterClass instanceof WarriorBehavior) {
            WarriorBehavior warrior = (WarriorBehavior) characterClass;
            if (!isInRange(target, warrior.getAttackRange())) {
                System.out.println("!!! " + name + " не может атаковать - цель слишком далеко!");
                return;
            }
        }

        System.out.println("⚡ " + name + " (" + getCharacterClassName() + ") использует способность на " + target.getName());
        characterClass.performAction(target);
    }

    private boolean isInRange(Player target, int range) {
        int distance = Math.abs(positionX - target.positionX) + Math.abs(positionY - target.positionY);
        return distance <= range;
    }

    public String getName() { return name; }
    public int getCurrentHealth() { return currentHealth; }
    public int getMaxHealth() { return maxHealth; }
    public boolean isAlive() { return isAlive; }
    public int getPositionX() { return positionX; }
    public int getPositionY() { return positionY; }
    public String getRaceName() { return race.getName(); }
    public String getCharacterClassName() { return characterClass.getClassName(); }

    @Override
    public String toString() {
        return String.format("👤 %s | %s %s | ❤️ %d/%d | 🛡️ %d | 📍 (%d,%d) | %s",
                name, getRaceName(), getCharacterClassName(),
                currentHealth, maxHealth, defense, positionX, positionY,
                isAlive ? "✅ жив" : "💀 мертв");
    }
}