package BattleShipGame;

public class BattleShipRun {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        printPlayerShipManifest(player1);


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
