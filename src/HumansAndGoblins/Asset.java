package HumansAndGoblins;
/*
    Parent class of all objects that exist on the board
    will allow the creation of an object on the gameBoard object.
 */
public class Asset {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    int [] location = new int[2];
    String icon;
    public KindOf kindOf;
    public Asset(){
         // Parent class ...more will be implemented in children class
    }

    public int[] getLocation() {  // return the location of an object
        return location;
    }

    public void setLocation(int[] location) {  // used to hard set a location
        this.location = location;
    }
}
