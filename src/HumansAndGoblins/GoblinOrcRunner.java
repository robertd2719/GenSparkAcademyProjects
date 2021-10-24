package HumansAndGoblins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GoblinOrcRunner {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        Human human = new Human(new int[]{1, 2}); // player will start @ position column = 1, row = 2;
        Goblin goblin1 = new Goblin(new int[]{3, 3}); // first goblin will start @ position column = 2, row = 3;

        GameWorld gameWorld = new GameWorld(8, 24);
        gameWorld.createItem(goblin1, goblin1.getLocation());
        gameWorld.createItem(human, human.getLocation());
        gameWorld.drawWorld();
        //test move over 3 loops
        Direction moveDirection;
        for (int i = 0; i < 5; i++) {
            // will move player (3) times
            moveDirection = selectMove();
            gameWorld.moveAsset(human,moveDirection);
            gameWorld.drawWorld();
        }

    }

    public static void MenuItems(GameWorld gameWorld) {
        System.out.println("-------------------------------------------------");
        System.out.println("                        MENU                     ");
        System.out.println("                      1. Move                    ");
//        System.out.println("                     2. Use Item                 ");
//        System.out.println("                     3. To Be Added              ");
        System.out.println("                                                 ");
        System.out.println("-------------------------------------------------");

    }

    public static Direction selectMove() {
//        @TODO moving offscreen will cause a null pointer exception ....needs to be checked
        System.out.println();
        System.out.println("Which direction would you like to move? :");
        System.out.println(ANSI_YELLOW+"\t\t\t (U)p ");
        System.out.println("\t\t\t (D)own ");
        System.out.println("\t\t\t (R)ight ");
        System.out.println("\t\t\t (L)eft ");
        System.out.println("\t\t\t (S)top Moving"+ ANSI_RESET);
        Scanner in = new Scanner(System.in);
        String reply = in.next().toUpperCase();
        switch (reply) {
            case "U":
                return Direction.UP;
            case "D":
                return Direction.DOWN;
            case "L":
                return Direction.LEFT;
            case "R":
                return Direction.RIGHT;
            default:
                return null;
        }
    }
}
