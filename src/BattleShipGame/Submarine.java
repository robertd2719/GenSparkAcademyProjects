package BattleShipGame;

public class Submarine extends Ship {
    public Submarine() {
        this.setShipHP(1);
        this.setShipLength(1);
        this.setShipName("Submarine");
    }

    public Submarine(String name){
        this.setShipName(name);
        this.setShipHP(1);
        this.setShipLength(1);
    }
}
