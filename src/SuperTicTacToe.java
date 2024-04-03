import java.util.Scanner;

public class SuperTicTacToe {
    private Space[][] row1;
    private Space[][] row2;
    private Space[][] row3;
    private boolean gameOver;
    private TicTacToe[] grid = new TicTacToe[9];
    public Scanner scan;
    public SuperTicTacToe () {
       scan = new Scanner(System.in);
       for (int i = 0;i < 9;i++) {
           grid[i] = new TicTacToe();
       }
    }

    public void Play() {
        int b = 0;
        int p = 0;
        System.out.println("Welcome to Super TicTacToe!");
        printGrid();
        System.out.print("Player 1: ");
        scan.nextLine();
        System.out.print("Player 2: ");
        scan.nextLine();
        System.out.println("Select box (1-9): ");
        b = scan.nextInt();
        grid[b -1].setColor(Color.GREEN);
        while (!gameOver) {
            printGrid();
            System.out.println("Player 1");
            System.out.println("Select position (1-9): ");
            p = scan.nextInt();
            grid[b - 1].Move(p, "X");
            System.out.println("Player 2: ");
            b = p;
            grid[b - 1].setColor(Color.GREEN);
            printGrid();
            p = scan.nextInt();
            grid[b - 1].Move(p, "0");
            b = p;
            grid[b - 1].setColor(Color.GREEN);
        }
    }

    private void printGrid() {
        for (int i = 0;i < 9;i += 3) {
            for (int r = 0;r < 3;r++) {
                System.out.print("|");
                grid[i].printRow(r);
                grid[i + 1].printRow(r);
                grid[i + 2].printRow(r);
                System.out.println();
            }
            System.out.println();
        }
    }
}
