package BattleShipGame;

import java.util.Locale;

public class BattleShipRun {
    public static void main(String[] args) {
        while(true){
            Player player1 = new Player();
            player1.getShipsOnBoard();
            Player player2 = new Player();
            player2.getShipsOnBoard();
            while(true){
                player1.attack(player2);
                if (!player2.getAliveStatus()) {
                    System.out.println("Player 1 Wins!");
                    break;
                }
                player2.attack(player1);
                if (!player1.getAliveStatus()){
                    System.out.println("Player 2 Wins!");
                    break;
                }
            }
            System.out.println("Would you like to play again? ");
            String answer = Player.getInput().toUpperCase();
            if (!answer.equals("Y")){
                System.out.println("Thank you for playing!!!");
                break;
            }
            else{
                Player.resetPlayerCount();
            }
        }

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
