package HumansAndGoblins;

public class Land extends Asset{

    public Land(int []currentLocation){
        this.kindOf = KindOf.LAND;
        this.location = currentLocation;
        this.icon = ANSI_GREEN + "-" + ANSI_RESET  ;
    }
}
