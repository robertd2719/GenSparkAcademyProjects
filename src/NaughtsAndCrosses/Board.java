package NaughtsAndCrosses;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Board {

    Marker[][] board;
    Marker playerPiece;
    Marker computerPiece;
    ArrayList<Integer> currentPieces;
    int rowCount;
    int columnCount;
    Map<Integer, Tuple> markerTranslate;

    //Setup the board for new game.
    public Board() {
        this.rowCount = 3;
        this.columnCount = 3;
        this.board = new Marker[rowCount][columnCount];
        this.currentPieces = new ArrayList<>();
        //setup our translation matrix!
        this.markerTranslate = new HashMap<>();
        this.markerTranslate = transLationMatrix();
    }

    // Draw the state of the board
    public void drawBoard() {
        boolean isNull;
        for (Marker[] markers : board) {
            for (Marker marker : markers) {
                isNull = (marker == null);
                System.out.print((isNull) ? "   |" : " " + marker + " |");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public void setPieces() {
        String temp;
        System.out.println("Please select a piece 'X' or 'O");
        Scanner in = new Scanner(System.in);
        temp = in.next().toLowerCase();
        in.close();
        this.playerPiece = (temp.equals("x")) ? Marker.X : Marker.O;

        System.out.println(" Your marker is: " + this.playerPiece);
        this.computerPiece = (this.playerPiece == Marker.X) ? Marker.O : Marker.X;
        System.out.println("Computer will be playing with " + this.computerPiece);
    }

    // Allow the player to place a marker @ a translated position on the board.
    public boolean placePiece(int n, Marker m) {
        // Check to see if the piece actually exists.
        boolean alreadyPlaced = this.currentPieces.stream()
                .anyMatch(e -> e == n);
        if (alreadyPlaced) {
            System.out.println("That place already filled");
            return false;
        }
        // if not in the index put it into the arrayList instance field
        this.currentPieces.add(n);
        int row_position = markerTranslate.get(n).row_value;
        int col_position = markerTranslate.get(n).column_value;
        board[row_position][col_position] = m;
        return true;
    }

    // Check the position of the playet @ any one given time
    public boolean checkOpenPosition(int n) {
        int row_position = markerTranslate.get(n).row_value;
        int col_position = markerTranslate.get(n).column_value;
        // check to see if it is an open position and return true if so
        return (this.board[row_position][col_position] == null) ? true : false;
    }

    public boolean isBoardFull() {
        int piecePresent = 0;
        int noPiecePresent = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == null) {
                    noPiecePresent++;
                }
                if (board[i][j] == Marker.O || board[i][j] == Marker.X) {
                    piecePresent++;
                }
            }
        }
        return (piecePresent == 9) ? true : false;
    }

    public Map<Integer, Tuple> transLationMatrix() {
        int counter = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.markerTranslate.put(counter, new Tuple(i, j));
                counter++;
            }
        }
        return markerTranslate;
    }

    public Marker CheckWinConditionMet() {
        //  Function that will take in
        Function<Marker, Predicate<Marker>> checkWin = compareMarker ->
                currentMarker -> currentMarker == compareMarker;

        ArrayList<Marker> checkListH = new ArrayList<>();
        ArrayList<Marker> checkListV = new ArrayList<>();
        ArrayList<Marker> checkListXRL = new ArrayList<>(Arrays.asList(null, null, null));
        ArrayList<Marker> checkListXLR = new ArrayList<>(Arrays.asList(null, null, null));

        boolean xWins = false;
        boolean yWins = false;
        //   Check for cross axis wins

        //   Check for horizontal and vertical wins
        for (int i = 0; i < this.rowCount; i++) {
            checkListH.clear();
            checkListV.clear();
//            checkListXLR.clear();
//            checkListXRL.clear();

            for (int j = 0; j < this.columnCount; j++) {
                checkListH.add(this.board[i][j]);
                checkListV.add(this.board[j][i]);
                // cross axis checks
            }

            // this will add one element after each iteration
            checkListXLR.set(i, this.board[i][i]);
            checkListXRL.set(i, this.board[i][2 - i]);

            //   Check to see if a Horizontal win condition exists;
            xWins = ((checkListH.stream().allMatch(e -> e == Marker.X)) ||
                    (checkListV.stream().allMatch(e -> e == Marker.X)) ||
                    (checkListXLR.stream().allMatch(e -> e == Marker.X)) ||
                    (checkListXRL.stream().allMatch(e -> e == Marker.X)));
            yWins = ((checkListH.stream().allMatch(e -> e == Marker.O)) ||
                    (checkListV.stream().allMatch(e -> e == Marker.O)) ||
                    (checkListXLR.stream().allMatch(e -> e == Marker.O)) ||
                    (checkListXRL.stream().allMatch(e -> e == Marker.O)));
            if (xWins || yWins) {
                return (xWins) ? Marker.X : Marker.O;
            }
        }
        return null;
    }
}

enum Marker {X, O}
