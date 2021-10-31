package BattleShipGame;

public class Destroyer extends Ship {

    public Destroyer() {
        this.setShipHP(2);
        this.setShipLength(2);
        this.setShipName("Destroyer");
    }

    public Destroyer(String name) {
        this.setShipName(name);
        this.setShipHP(2);
        this.setShipLength(2);
    }
}
