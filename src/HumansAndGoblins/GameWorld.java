package HumansAndGoblins;

import java.util.Arrays;

public class GameWorld {
    private int width;
    private int height;
    private Asset [][] worldItems;    // columns x rows

    // This will simply create a blank game world
    public GameWorld(int height, int width){
        this.width = width;      // width of the game world = # of columns
        this.height = height;    // height of the game world = # of rows
        this.worldItems = new Asset[height][width]; // will set up the game world with the given attributes
        this.makeLand();
    }

    public void createItem(Asset itemToBeAdded, int [] location){
        int row = location[0];
        int column = location[1];
        this.worldItems[row][column] = itemToBeAdded;
    }
    public void moveAsset(Asset item_to_move, Direction d){
        // @TODO RECODE THIS ENTIRE THING USING TUPLES INSTEAD OF ARRAYS --
                System.out.println("Moving "+item_to_move.getClass()+ " : "+d);
        int currentLocationY = item_to_move.getLocation()[0];
        int currentLOcationX = item_to_move.getLocation()[1];
        int [] oldLocation = item_to_move.getLocation();
                System.out.println("current position: "+ Arrays.toString(item_to_move.getLocation()));

        // Switch determines where to actually move the
        switch (d){
            case RIGHT:
                item_to_move.setLocation(new int[]{currentLocationY,currentLOcationX+1});
                break;
            case LEFT:
                item_to_move.setLocation(new int[]{currentLocationY,currentLOcationX-1});
                break;
            case DOWN:
                item_to_move.setLocation(new int[]{currentLocationY+1,currentLOcationX});
                break;
            case UP:
                item_to_move.setLocation(new int[]{currentLocationY-1, currentLOcationX});
                break;
        }
        // need to update the world item array with the new location of the item itself
        this.worldItems[currentLocationY][currentLOcationX] = new Land(oldLocation);
        // how do you break items out of an array ?
        int newLocationY = item_to_move.getLocation()[0];
        int newLocationX = item_to_move.getLocation()[1];
        this.worldItems[newLocationY][newLocationX] = item_to_move;
                System.out.println("Position after "+d+ ": "+ Arrays.toString(item_to_move.getLocation()));
    }

    public void drawWorld(){
        System.out.println();
        for (int i = 0; i < this.height; i++) {
            System.out.print("\t\t");
            for (int j = 0; j < this.width; j++) {
                if (this.worldItems[i][j].kindOf == KindOf.LAND){
                    System.out.print(this.worldItems[i][j].icon);
                }else {
                    System.out.print(this.worldItems[i][j].icon);
                }
            }
            System.out.println();
        }
    }

    public void makeLand(){
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.worldItems[i][j] = new Land(new int[]{i,j});
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Asset[][] getWorldItems() {
        return worldItems;
    }

    public void setWorldItems(Asset[][] worldItems) {
        this.worldItems = worldItems;
    }
}
