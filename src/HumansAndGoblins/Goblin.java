package HumansAndGoblins;

import java.util.Arrays;

public class Goblin extends Asset{
    private double health, attack, armor;
    private boolean isAlive;
    Goblin(int [] currentLocation){
        this.location = currentLocation;
        this.health = 100;
        this.attack = 10;
        this.armor = 5;
        // Set icon for "G" for goblin
        this.icon = "G";
        this.isAlive = true;
        System.out.println("New Goblin created!!");
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
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
        return "Goblin{" +
                "location=" + Arrays.toString(location) +
                ", icon='" + icon + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", armor=" + armor +
                ", isAlive=" + isAlive +
                '}';
    }
}
