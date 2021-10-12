package Project_Dragon_Cave;

import java.util.Scanner;

/*
    This project will allow a player to go on a small choose your own adventure quest.
    It is very limited in scope and only allows the user to select input from the keyboard
    using a scanner object and only (2) choices will be given
 */
public class DragonCave {
    public static void main(String[] args) {
        runGameRound();
    }
    public static void runGameRound(){
        Scanner in = new Scanner(System.in);
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");

        //@TODO error checking needs to be done for improper input by user
        //@TODO Make a loop to allow the user to play multiple games.
        int answer = in.nextInt();
        switch(answer){
            case 1:
                System.out.println("\n" +
                        "You approach the first cave...\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                        "Gobbles you down in one bite!");
                break;
            case 2:
                System.out.println("\n" +
                        "You approach the second cave...\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                        "Laughs heartily as he hands you a giant margarita and funny hat");
                break;
            default:
                System.out.println("You take your ball and go home");
                break;
        }
        //
    }
}
