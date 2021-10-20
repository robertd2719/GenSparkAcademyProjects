package NaughtsAndCrosses;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RunGame {
    public static void main(String[] args) throws InterruptedException {
        boolean playAgain = true;
        while(playAgain) {
            Board board = new Board();
            System.out.println("Welcome to Tic Tac Toe!");
            board.setPieces();


            while (true) {
                if (board.isBoardFull()) {
                    break;
                }
                if (board.CheckWinConditionMet() == board.playerPiece) {
                    System.out.println("Player wins!");
                    break;
                }
                computerMove(board, board.computerPiece);
                if (board.isBoardFull()) {
                    break;
                }
                if (board.CheckWinConditionMet() == board.computerPiece) {
                    System.out.println("Computer wins!");
                    break;
                }
                playerMove(board, board.playerPiece);
            }
            System.out.println("Game Over would you like to play again 'Y' or 'N' ?...");
            Scanner scanner = new Scanner(System.in);
            String temp = scanner.next().toLowerCase();
            if (temp.equals("n")){
                playAgain = false;
                break;
            }
        }
    }

    public static Board computerMove(Board board, Marker cpuMarker) throws InterruptedException {
        System.out.println("THe computer is thinking ........");
        System.out.println();
        TimeUnit.SECONDS.sleep(2);
        boolean isGoodSPot = false;
        int randomRoll;
        while (!isGoodSPot) {
            randomRoll = new Random().nextInt(9) + 1;
            boolean computerPlacedSuccess =
                    board.placePiece(randomRoll, cpuMarker);
            if (!computerPlacedSuccess) {
                isGoodSPot = false;
                continue;
            } else isGoodSPot = true;
        }
        board.drawBoard();
        System.out.println();
        return board;

    }
    public static Board playerMove(Board board, Marker playerMarker){

        System.out.println("Player Move: Please select 1 - 9");
        int response;
        Scanner scanner = new Scanner(System.in);
        boolean isGoodSpot = false;
        while (!isGoodSpot){
            response = scanner.nextInt();
            boolean playerPlacedSuccess =
                    board.placePiece(response,playerMarker);
            if (!playerPlacedSuccess) {
                System.out.println("That position is taken, please enter 1 - 9");
                isGoodSpot = false;
            } else {
                isGoodSpot = true;
            }
        }

        board.drawBoard();
        System.out.println();
        return board;
    }
}
