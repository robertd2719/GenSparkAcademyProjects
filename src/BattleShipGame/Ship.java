package BattleShipGame;

public abstract class Ship {
    private int shipHP;
    private int shipLength;
    private String shipName;

    public Ship() {
    }

    public int getShipHP() {
        return shipHP;
    }

    public void setShipHP(int shipHP) {
        this.shipHP = shipHP;
    }

    public int getShipLength() {
        return shipLength;
    }

    public void setShipLength(int shipLength) {
        this.shipLength = shipLength;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public void removeHP() {
        this.setShipHP(this.getShipHP() - 1);
    }

    @Override
    public String toString() {
        return Character.toString(this.getShipName().charAt(0));
    }
}
