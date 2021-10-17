package HangManProduction;

import java.util.Scanner;

public class HangManGame {
    int numCorrect;  // number of correct guesses
    int numWrong;    // number of incorrect guesses
    int maxWrong;
    String secretWord;  // String of characters to represent our secret word
    String lettersFoundString;  // the output display of our secret word
    String incorrectLettersString; // the output display of our missed wordss.
    Hangman hangman;  // this will be used to update and display the state of our hangman
    String guess;

    HangManGame(){
        secretWord = new SecretWord().getSecretWord();
        numCorrect = 0;
        numWrong = 0;
        maxWrong = 8;
        incorrectLettersString = "";
        lettersFoundString = "";
        hangman = new Hangman();

    }

    public static void main(String[] args) {
        boolean playAgain = true;
        while (playAgain) {
            HangManGame game = new HangManGame();
            System.out.println("HANGMAN");
            while (game.numWrong < game.maxWrong) {
                game.hangman.drawHangman();
                System.out.println("Incorrect Letters: " + game.incorrectLettersString);

                game.lettersFoundString = updateSecretWordDisplay(game.secretWord, game.lettersFoundString);
                System.out.println(game.lettersFoundString);

                System.out.println("Please choose a letter");
                game.guess = getInput().toUpperCase();

                if (game.secretWord.contains(game.guess)) {
                    game.lettersFoundString += game.guess;
                    game.lettersFoundString = updateSecretWordDisplay(game.secretWord, game.lettersFoundString);
                    System.out.println("You chose correctly");
                } else {
                    if (!game.incorrectLettersString.contains(game.guess))
                        game.incorrectLettersString += game.guess + " ";
                    game.numWrong++;
                    game.hangman.updateHangman();
                    if (game.numWrong < game.maxWrong)
                        System.out.println("Sorry Try again!!!");
                }
                if (game.secretWord.equals(game.lettersFoundString)) {
                    System.out.println("\n\n\n****CONGRATULATIONS YOU WIN****\n\n");
                    break;
                }
                else if (game.numWrong == game.maxWrong )
                    System.out.println("\n******GAME OVER******");
            }
            System.out.println("Would you like to play again?");
            if (getInput().toLowerCase().equals("y")){
                playAgain = true;
            }
            else playAgain = false;
        }
    }

    public static String updateSecretWordDisplay(String secretWord, String lettersFoundString){
        StringBuilder sb = new StringBuilder();
        sb.append("_".repeat(secretWord.length()));

        for (int i= 0; i<secretWord.length(); i++){
            for (int idx=0; idx<lettersFoundString.length(); idx++) {
                if (secretWord.charAt(i) == lettersFoundString.charAt(idx)) {
                    sb.setCharAt(i, secretWord.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    public static String updateIncorrectLettersString(String wrongLetter,String wrongLetters){
        return wrongLetters.concat(wrongLetter);
    }

    public static String getInput(){

        Scanner in = new Scanner(System.in);
        String reply = in.next();
        return reply;
    }


}
