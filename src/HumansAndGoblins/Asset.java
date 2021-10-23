package HumansAndGoblins;
/*
    Parent class of all objects that exist on the board
    will allow the creation of an object on the gameBoard object.
 */
public class Asset {
    int [] location = new int[2];
    String icon;
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
