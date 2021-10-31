package BattleShipGame;

public class GameBoard {
    private Ship [][] gameBoard;

    public GameBoard(){
        this.gameBoard = new Ship[10][10];
    }
    public void displayShipsOnBoard(){
        System.out.println("  0 1 2 3 4 5 6 7 8 9 ");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[i][j] == null){
                    System.out.print("~ ");
                }else {
                    System.out.print(gameBoard[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    // @TODO --FIRE-- add regular expression checker; check for bounds of ships during placement
    public void addShipToBoard(Ship ship){
        System.out.print("Enter coordinates (x,y) for your "+ship.getShipName()+": ");
        String input="";
        Tuple<Integer,Integer> location = new Tuple<>(0,0);
        try{
            input = Player.getInput();
            location =  valuesToTuple(input);
        }catch (Exception e){
            System.out.println("Bad Coordinates - Please Re-enter");
        }
        this.gameBoard[location.getY()][location.getX()] = ship;

    }
    public static Tuple<Integer,Integer> valuesToTuple(String inString){
        var y_value = Integer.parseInt(String.valueOf(inString.charAt(1)));
        var x_value = Integer.parseInt((String.valueOf(inString.charAt(3))));
        return new Tuple<>(y_value,x_value);
    }
}
