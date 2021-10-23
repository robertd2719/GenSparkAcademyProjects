package HumansAndGoblins;

public class GameWorld {
    private int width;
    private int height;
    private Asset [][] worldItems;    // columns x rows

    // This will simply create a blank game world
    public GameWorld(int height, int width){
        this.width = width;      // width of the game world = # of columns
        this.height = height;    // height of the game world = # of rows
        this.worldItems = new Asset[height][width]; // will set up the game world with the given attributes
    }

    public void createItem(Asset itemToBeAdded, int [] location){
        int row = location[0];
        int column = location[1];
        this.worldItems[row][column] = itemToBeAdded;
    }

    public void drawWorld(){
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.worldItems[i][j] == null){
                    System.out.print("-");
                }else {
                    System.out.print(this.worldItems[i][j].icon);
                }
            }
            System.out.println();
        }
    }



}
