package JavaClass2;

import java.util.Scanner;

public class Homework2Part1 {
    public static void main(String[] args) {
        System.out.println("Game Starting...");
        Scanner s = new Scanner(System.in);
        System.out.println("Player1: Press any key to roll the die.");
        System.out.println("Player1: Rolling die...");
        System.out.println("Player2: Press any key to roll the die. ");
        System.out.println("Player2: Rolling die...");
        int playerOne = (int) (Math.random()*6);
        int playerTwo = (int) (Math.random()*6);
        while (playerOne == playerTwo) {
            playerOne = (int) (Math.random()*6);
            playerTwo = (int) (Math.random()*6);
        }
        if (playerOne > playerTwo) {
                System.out.println("The winner is: Player 1, who rolled a " + playerOne);
                System.out.println("The loser is: Player 2, who rolled a " + playerTwo);
        }
        else if (playerOne < playerTwo) {
            System.out.println("The winner is: Player 2, who rolled a " + playerTwo);
            System.out.println("The loser is: Player 1, who rolled a " + playerOne);
        }
        s.close();
        


        
    }
}