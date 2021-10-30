package BattleShipGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    static int playerNumber = 1;
    private String name;
    private boolean isAlive;
    private int shipsRemaining;
    private ArrayList<Ship> playerShips = new ArrayList<>();

    /*
        Player class constructor for setting up a game of Battleship.
     */
    public Player() {
        inputPlayerName();
        populatePlayerShipPool();
        //Lastly, update player index to reflect new value for playerNumber.
        playerNumber += 1;
    }
    /*
        playerWasHit - cycle through list of player list and deduct HP;
            remove from list if ship hp is zero
     */
    //@TODO refactor this if necessary
    public void playerWasHit(String shotShip){
        for (Ship ship: this.playerShips){
            if (ship.getShipName().equals(shotShip)){
                ship.removeHP();
            }
        }
    }

    /*
        Return total number of ships the player has remaining.
     */
    public int getShipsRemaining() {
        return this.playerShips.size();
    }

    public void inputPlayerName() {
        System.out.print("\nWelcome player: " + playerNumber + " please enter your name: ");
        this.name = getInput();
    }

    /*
        On creation will populate each type and number of ships into the players pool
     */
    public void populatePlayerShipPool() {
        this.playerShips.add(new AirCraftCarrier());
        this.playerShips.add(new BattleShip());
        this.playerShips.add(new Cruiser());
        this.playerShips.add(new Destroyer("Destroyer I"));
        this.playerShips.add(new Destroyer("Destroyer II"));
        this.playerShips.add(new Submarine("Submarine I"));
        this.playerShips.add(new Submarine("Submarine II"));
    }

    /*
        getInput is a utility function that will be used by the program for all user input.
     */
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        //@TODO return a checked expression in a loop if possible
        try {
            input = scanner.next();

        } catch (Exception e) {
            System.out.println("Sorry, that name could not be recognized!");
        }
        return input;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Ship> getPlayerShips() {
        return this.playerShips;
    }
}

