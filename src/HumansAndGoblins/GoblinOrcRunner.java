package HumansAndGoblins;

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

    public static void main(String[] args) throws InterruptedException {

        Human human = new Human(new int[]{1, 2}); // player will start @ position column = 1, row = 2;
        Goblin goblin1 = new Goblin(new int[]{3, 3}); // first goblin will start @ position column = 2, row = 3;

        GameWorld gameWorld = new GameWorld(8, 24);
        gameWorld.createItem(goblin1, goblin1.getLocation());
        gameWorld.createItem(human, human.getLocation());
        gameWorld.drawWorld();
        //test move over 3 loops
        Direction moveDirection;
        Direction goblinMoveDirection;
        while(true) {
            // will move player (3) times
            moveDirection = selectMove();
            gameWorld.moveAsset(human, moveDirection);
            gameWorld.drawWorld();
//            goblinMoveDirection = goblinMove(gameWorld, human, goblin1);
//            gameWorld.moveAsset(goblin1,goblinMoveDirection);
            if(checkCombat(gameWorld, human, goblin1)){
                goblin1.attack(human);
                if ((!goblin1.isAlive())||(!human.isAlive())){
                    System.out.println("GAME OVER");
                    break;
                }
            }
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
        System.out.println(ANSI_YELLOW + "\t\t\t (U)p ");
        System.out.println("\t\t\t (D)own ");
        System.out.println("\t\t\t (R)ight ");
        System.out.println("\t\t\t (L)eft ");
        System.out.println("\t\t\t (S)top Moving" + ANSI_RESET);
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

    public static boolean checkCombat(GameWorld gameWorld, Human human, Goblin goblin) {
        int humanPosX = human.getLocation()[1];
        int humanPosY = human.getLocation()[0];

        int goblinPosX = goblin.getLocation()[1];
        int goblinPosY = goblin.getLocation()[0];

        if ((goblinPosY == humanPosY) && ((goblinPosX + 1 == humanPosX) || (goblinPosX - 1 == humanPosX))) {
            System.out.println("COMBAT INITIATED");
            return true;
        }
        if ((goblinPosX == humanPosX) && ((goblinPosY + 1 == humanPosY) || (goblinPosY - 1 == humanPosY))) {
            System.out.println("COMBAT INITIATED");
            return true;
        }
        return false;

    }

    public static Direction goblinMove(GameWorld gameWorld, Human human, Goblin goblin) {
        // Create flag for goblin army
        Direction outMove;
        // unpack locatios to variables note locations are backwards.
        int humanPosX = human.getLocation()[1];
        int humanPosY = human.getLocation()[0];
        int goblinPosX = goblin.getLocation()[1];
        int goblinPosY = goblin.getLocation()[0];

        if ((goblinPosY > humanPosY) || (goblinPosY < humanPosY)) {
            if (((goblinPosY + 1 == humanPosY) || (goblinPosY - 1 == humanPosY)) && (goblinPosX == humanPosX)) {  //player and goblin are (1) square from each other.
                System.out.println("GOBLIN ATTACK INITIATED");
                outMove = Direction.ATTACK;
            } else {
                // Player is at an offset from goblin or more than 1 space away vertically
                if (goblinPosY < humanPosY) {
                    outMove = Direction.DOWN;
                } else {
                    outMove = Direction.UP;
                }
            }
        } else {  // Goblin is above or below the goblin...check to see if they are close and move left or right
            if ((goblinPosX + 1 == humanPosX) || (goblinPosX - 1 == humanPosX)) {
                System.out.println("GOBLIN ATTACK INITIATED");
                outMove = Direction.ATTACK;
            } else {
                if (goblinPosX > humanPosX) {
                    outMove = Direction.LEFT;
                } else {
                    outMove = Direction.RIGHT;
                }
            }
        }
        return outMove;
    }
}

