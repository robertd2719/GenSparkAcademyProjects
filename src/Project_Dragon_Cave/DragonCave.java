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
        // get user input and store as int variable
        //@TODO error checking needs to be done for improper input by user here
        int answer = in.nextInt();
        System.out.println("You picked cave "+ answer);
        //
    }
}
