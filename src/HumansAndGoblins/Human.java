package HumansAndGoblins;

import java.util.Arrays;

public class Human extends Asset {
    private double health,armor;
    private boolean isAlive;
    int attack;

    public Human(int[] currentLocation) {
        this.kindOf = KindOf.HUMAN;
        this.location = currentLocation;
        this.health = 100;  // intial value for health
        this.attack = 10;
        this.armor = 5;
        // Icon for Human class
        this.icon = ANSI_BLUE+"H"+ANSI_RESET;
        isAlive = true;
        System.out.println(ANSI_BLUE+"\t\tNew Human created!"+ANSI_RESET);
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Human{" +
                "location=" + Arrays.toString(location) +
                ", icon='" + icon + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                ", isAlive=" + isAlive +
                '}';
    }
}
