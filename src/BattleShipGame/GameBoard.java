package BattleShipGame;

public class GameBoard {
    private Ship[][] gameBoard;
    private String[][] gameView;

    public GameBoard() {
        this.gameBoard = new Ship[10][10];
        this.gameView = new String[10][10];
    }

    public void displayShipsOnBoard() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9 ");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[i][j] == null) {
                    System.out.print("~ ");
                } else {
                    System.out.print(gameBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void displayGameView() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9 ");
        for (int i = 0; i < gameView.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gameView.length; j++) {
                if (gameView[i][j] == null) {
                    System.out.print("~ ");
                } else {
                    System.out.print(gameView[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    public void setGameView(String updateValue, Tuple<Integer,Integer> position){
        gameView[position.getX()][position.getY()] = updateValue;
    }

    // @TODO add regular expression checker
    public void addShipToBoard(Ship ship) {
        this.displayShipsOnBoard();
        String direction = "";
        System.out.print("Enter coordinates (x,y) for your " + ship.getShipName() + ": ");
        String input;
        Tuple<Integer, Integer> location = new Tuple<>(0, 0);
        try {
            input = Player.getInput();
            location = valuesToTuple(input);
        } catch (Exception e) {
            System.out.println("Bad Coordinates - Please Re-enter");
        }
        this.gameBoard[location.getY()][location.getX()] = ship;
        // @TODO check bounds during re-write
        System.out.print("Place (V)ertically or (H)orizontally: ");
        try {
            direction = Player.getInput().toUpperCase();
        } catch (Exception e) {
            System.out.println("Input not recognized please enter 'V' or 'H'");
        }
        if (direction.equals("V")) {
            for (int i = 0; i < ship.getShipLength(); i++) {
                // this should add elements vertically
                this.gameBoard[location.getY() + i][location.getX()] = ship;
            }
        } else {
            System.out.println("You chose Horizontal");
            // this should add elements horizontally
            for (int i = 0; i < ship.getShipLength(); i++) {
                this.gameBoard[location.getY()][location.getX() + i] = ship;
            }
        }


    }

    // check a given postion in a gameboard and return a ship if it exists.
    public Ship checkPostionForAttack(Tuple<Integer,Integer> position){
        if (this.gameBoard[position.getY()][position.getX()] != null){
            return this.gameBoard[position.getY()][position.getX()];
        }
        return null;
    }

    public static Tuple<Integer, Integer> valuesToTuple(String inString) {
        var y_value = Integer.parseInt(String.valueOf(inString.charAt(1)));
        var x_value = Integer.parseInt((String.valueOf(inString.charAt(3))));
        return new Tuple<>(y_value, x_value);
    }
}
