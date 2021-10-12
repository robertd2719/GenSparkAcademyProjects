package GuessNumberGame;
/*
    NumberGuessGame.
    User must guess the number within 6 tries.
 */

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {

//        Init random variables
        Random random = new Random();
        Scanner inString = new Scanner(System.in);
        Scanner inValue = new Scanner(System.in);
        int numberGuesses = 1;
        int userGuess = 0;
        int allowedTries = 6;
        int secretNumber = random.nextInt(21);
        String userName;
        boolean keepPlaying = true;

        System.out.println("Hello!, what is your name? ");
        userName = inString.nextLine();
        while (keepPlaying == true) {
            System.out.println("Well, " + userName + " I am thinking of a number between 1 and 20." +
                    "\nTake a guess.\n");

            while (numberGuesses <= allowedTries) {
//            @TODO need to perform error checking on this as well
                userGuess = inValue.nextInt();
                if (userGuess == secretNumber) {
                    System.out.println("Good Job, " + userName + "you guessed my number in " + numberGuesses + " guesses");
                    break;
                }
                if (userGuess < secretNumber) {
                    System.out.println("Your guess is too low\n" + "Take a guess");
                    numberGuesses++;
                } else {
                    System.out.println("Your guess is too high\n" + "Take a guess");
                    numberGuesses++;
                }
            }

            System.out.println("Would you like to play another round ? (y/n)");
            inString = new Scanner(System.in);
            String anotherRound = inString.nextLine().toLowerCase();
            if (anotherRound.equals("y")){
                continue;
            }

            else if (anotherRound.equals("n")){
                keepPlaying = false;
            }
        }
    }
}
