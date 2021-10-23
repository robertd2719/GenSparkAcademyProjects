package GoblinsAndOrcs;

import java.util.ArrayList;

public class GameWorld {
    private int width;
    private int height;
    private Asset [][] worldItems;    // columns x rows

    public GameWorld(int width, int height){
        this.width = width;      // width of the game world = # of columns
        this.height = height;    // height of the game world = # of rows
        this.worldItems = new Asset[width][height]; // will set up the game world with the given attributes
    }
    public void createItem(Asset itemToBeAdded, int [] location){
        int row = location[0];
        int column = location[1];
        this.worldItems[row][column] = itemToBeAdded;
    }



}
