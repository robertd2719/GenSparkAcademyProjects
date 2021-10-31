package BattleShipGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    static int playerCount = 1;
    private int playerNumber;
    private String name;
    private boolean isAlive;
    private int shipsRemaining;
    private ArrayList<Ship> playerShips;
    private GameBoard gameboard;

    /*
        Player class constructor for setting up a game of Battleship.
     */
    public Player() {
        this.playerShips = new ArrayList<>();
        this.gameboard = new GameBoard();
        this.isAlive = true;
        this.playerNumber = playerCount;
        //@TODO offload this to a player run or setup Method
        inputPlayerName();
        populatePlayerShipPool();
        System.out.println("Welcome, "+this.getName());

        //Lastly, update player index to reflect new value for playerNumber.
        //@TODO make sure to reset this value to 0 before ending the game while loop
        playerCount += 1;
    }

    /*
        playerWasHit - cycle through list of player list and deduct HP;
            remove from list if ship hp is zero
     */
    //@TODO need to add end of game message to this list.
    public void playerWasHit(String shotShip) {
        for (Ship ship : this.playerShips) {
            if (ship.getShipName().equals(shotShip)) {
                ship.removeHP();
                System.out.println("Player " + this.playerNumber +
                        " ship " + ship.getShipName() + " was hit.");
            }
            // remove the ship from the players list if its value = 0;
            if (ship.getShipHP() <= 0) {
                this.playerShips.remove(ship);
                System.out.println("Player " + this.playerNumber +
                        " ship " + ship.getShipName() + " was sunk.");
            }
            // If player's arrayList is empty set isALive = false;
            if (this.playerShips.size() == 0) {
                this.isAlive = false;
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


    public String getName() {
        return this.name;
    }

    public Ship getShipFromList(String shipName) {
        Ship returnShip = null;
        for (Ship ship : this.playerShips) {
            if (shipName.equals(ship.getShipName())) {
                returnShip = ship;
            }
        }
        return returnShip;
    }

    public ArrayList<Ship> getPlayerShips() {
        return this.playerShips;
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
}

