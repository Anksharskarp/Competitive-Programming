package intermediate.homework.Homework1;

import java.util.*;

public class TicTacToe {

    private static boolean first = false;
    private static final char[][] board = new char[3][3];
    private static int aiScore = 0;
    private static int playerScore = 0;


    public static void main(String[] args){
        start();
    }

    public static void start(){

        Scanner console = new Scanner(System.in);

        System.out.println();
        System.out.println();
        System.out.println("Welcome to Tic-Tac-Toe");
        System.out.println("To play this classic game against the computer,");
        System.out.println("You will choose where to play using coordinates(1-3)");
        System.out.println();
        System.out.println("Would you like to go first (y or n)?");
        String goFirst = console.nextLine();

        if(goFirst.substring(0,1).equalsIgnoreCase("y")){
            first = true;
        }
        createBoard();
        displayBoard();
        startGame(console);


    }


    public static void startGame(Scanner console){
        if(first){
            userPlay(console);
        }else{
            computerPlay(console);
        }
    }

    public static void userPlay(Scanner scanner){
        System.out.println("Where would you like to play?");

        int r = scanner.nextInt() - 1;
        int c = scanner.nextInt() - 1;

        if(board[r][c] == ' '){
            board[r][c] = 'X';

            if(board[0][0] == 'X'){
                displayBoard();
                playerScore += 1;
                checkUserScore(scanner);

            } else if(board[0][2] == 'X'){
                displayBoard();
                playerScore += 3;
                checkUserScore(scanner);

            } else if(board[2][0] == 'X'){
                displayBoard();
                playerScore += 1000;
                checkUserScore(scanner);

            } else if(board[2][2] == 'X'){
                displayBoard();
                playerScore += 3000;
                checkUserScore(scanner);

            } else if(board[1][1] == 'X'){
                displayBoard();
                playerScore += 200;
                checkUserScore(scanner);

            } else if(board[0][1] == 'X'){
                displayBoard();
                playerScore += 2;
                checkUserScore(scanner);

            } else if(board[1][0] == 'X'){
                displayBoard();
                playerScore += 100;
                checkUserScore(scanner);

            } else if(board[1][2] == 'X'){
                displayBoard();
                playerScore += 300;
                checkUserScore(scanner);

            } else if(board[2][1] == 'X'){
                displayBoard();
                playerScore += 2000;
                checkUserScore(scanner);
            }

        } else if (board[r][c] == 'X' || board[r][c] == 'O'){
            first = true;
            System.out.println("Please choose an empty space");
            startGame(scanner);
        }

        System.out.println("It's a tie!");

    }


    public static void computerPlay(Scanner scanner){

        System.out.println("Now it's my turn");
        System.out.println();

        if(board[0][0] == ' '){
            board[0][0] = 'O';
            displayBoard();
            userPlay(scanner);
            aiScore += 1;

        } else if(board[0][2] == ' '){
            board[0][2] = 'O';
            displayBoard();
            userPlay(scanner);
            aiScore += 3;

        } else if(board[2][0] == ' '){
            board[2][0] = 'O';
            displayBoard();
            userPlay(scanner);
            aiScore += 1000;

        } else if(board[2][2] == ' '){
            board[2][2] = 'O';
            displayBoard();
            userPlay(scanner);
            aiScore += 3000;

        } else if(board[1][1] == ' '){
            board[1][1] = 'O';
            displayBoard();
            userPlay(scanner);
            aiScore += 200;

        } else if(board[0][1] == ' '){
            board[0][1] = 'O';
            displayBoard();
            userPlay(scanner);
            aiScore += 2;

        } else if(board[1][0] == ' '){
            board[1][0] = 'O';
            displayBoard();
            userPlay(scanner);
            aiScore += 100;

        } else if(board[1][2] == ' '){
            board[1][2] = 'O';
            displayBoard();
            userPlay(scanner);
            aiScore += 300;

        } else if(board[2][1] == ' '){
            board[2][1] = 'O';
            displayBoard();
            userPlay(scanner);
            aiScore += 2000;
        }


    }

    public static void checkUserScore(Scanner console){
        if(aiScore == 3201 || aiScore == 1203 || aiScore == 6 ||
                aiScore == 600 || aiScore == 6000 || aiScore == 1101 ||
                aiScore == 2202 || aiScore == 3303){
            System.out.println("Computer wins!");
            start();

        } else if (playerScore == 3201 || playerScore == 1203 || playerScore == 6 ||
                playerScore == 600 || playerScore == 6000 || playerScore == 1101 ||
                playerScore == 2202 || playerScore == 3303){
            System.out.println("You won!");
            start();
        } else {
            computerPlay(console);
        }
    }
    public static void checkComputerScore(Scanner console){
        if(aiScore == 3201 || aiScore == 1203 || aiScore == 6 ||
                aiScore == 600 || aiScore == 6000 || aiScore == 1101 ||
                aiScore == 2202 || aiScore == 3303){
            System.out.println("Computer wins!");
            start();

        } else if (playerScore == 3201 || playerScore == 1203 || playerScore == 6 ||
                playerScore == 600 || playerScore == 6000 || playerScore == 1101 ||
                playerScore == 2202 || playerScore == 3303){
            System.out.println("You won!");
            start();
        } else {
            userPlay(console);
        }
    }

    public static void createBoard(){

        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                board[r][c] = ' ';
            }
        }

    }

    public static void displayBoard(){

        String bar = "  =============";
        System.out.println("    1   2   3");
        System.out.println(bar);
        System.out.println("1   " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println(bar);
        System.out.println("2   " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println(bar);
        System.out.println("3   " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println(bar);
        System.out.println();


    }

}