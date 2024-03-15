import java.util.Scanner;

public class SuperTicTacToe {
    private Space[][] row1;
    private Space[][] row2;
    private Space[][] row3;
    private boolean gameOver;
    public Scanner scan;
    public SuperTicTacToe () {
       scan = new Scanner(System.in);
    }

    public void Play() {
        System.out.println("Welcome to Super TicTacToe!");
        System.out.print("Player 1: ");
        scan.nextLine();
        System.out.print("Player 2: ");
        scan.nextLine();
        System.out.println("Flipping a coin!");
        System.out.println("Player 1: X");
        System.out.print("Select the grid: ");
        while (!gameOver) {
            System.out.print("Player 1: ");
            System.out.print("Player 2: ");
        }


    }

}
