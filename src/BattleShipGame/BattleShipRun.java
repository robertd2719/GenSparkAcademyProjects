package BattleShipGame;

public class BattleShipRun {
    public static void main(String[] args) {
//        Player player1 = new Player();
//        player1.getShipsOnBoard();
//        Player player2 = new Player();
//        player2.getShipsOnBoard();
        //------------Above code is complete for basic gametime run sequence---
        //@TODO test code goes below, please remove when advisable.


    }

    public static void printPlayerShipManifest(Player player) {
        System.out.println("\nPlayer: " + player.getName() + " ship manifest");
        for (Ship ship : player.getPlayerShips()) {
            System.out.println("Name: " + ship.getShipName());
            System.out.println("Length: " + ship.getShipLength());
            System.out.println("Health: " + ship.getShipHP());
            System.out.println("Marker: " + ship);
        }
        System.out.println("Current Ship Compliment " + player.getShipsRemaining());
    }
}
