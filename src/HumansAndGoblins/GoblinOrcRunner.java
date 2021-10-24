package HumansAndGoblins;

import java.util.ArrayList;
import java.util.Arrays;

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

        Human human = new Human(new int[]{1,2}); // player will start @ position column = 1, row = 2;
        Goblin goblin1 = new Goblin(new int[]{3,3}); // first goblin will start @ position column = 2, row = 3;

        GameWorld gameWorld = new GameWorld(8,24);
        gameWorld.createItem(goblin1,goblin1.getLocation());
        gameWorld.createItem(human, human.getLocation());
        gameWorld.drawWorld();
    }
    public static void MoveTester(GameWorld gameWorld){



    }
}
