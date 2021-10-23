package HumansAndGoblins;

import java.util.ArrayList;

public class GoblinOrcRunner {
    public static void main(String[] args) {

        Human human = new Human(new int[]{1,2}); // player will start @ position column = 1, row = 2;
        Goblin goblin1 = new Goblin(new int[]{3,3}); // first goblin will start @ position column = 2, row = 3;

        GameWorld gameWorld = new GameWorld(8,20);
        gameWorld.createItem(goblin1,new int[]{1,2});
        gameWorld.createItem(human,new int[]{5,5});
        gameWorld.drawWorld();



    }
}
