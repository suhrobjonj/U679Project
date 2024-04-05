import java.util.Scanner;

public class SuperTicTacToe {
    private boolean gameOver;
    private TicTacToe currentBoard;
    private Space currentTurn;
    private TicTacToe[] grid = new TicTacToe[9];
    public Scanner scan;
    public SuperTicTacToe () {
       scan = new Scanner(System.in);
       for (int i = 0;i < 9;i++) {
           grid[i] = new TicTacToe(i + 1);
       }
    }

    public void Play() {
        int pos = 0;
        currentTurn = new O();
        System.out.println("Welcome to Super TicTacToe!");
        printBoardNumbers();
        System.out.print("Select board (1-9): ");
        setCurrentBoard(scan.nextInt());
        while (!gameOver) {
            printGrid();
            System.out.println("Select position (1-9): ");
            printCurrentTurn();
            pos = scan.nextInt();
            while (!currentBoard.canMove(pos)) {
                printCurrentTurn();
                pos = scan.nextInt();
            }
            currentBoard.Move(pos, currentTurn);
            setCurrentBoard(pos);
            checkGameOver();
        }
        printGrid();
        changeTurn();
        currentTurn.print(Color.RESET);
        System.out.print(" WINS!!!");
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

    private void printBoardNumbers() {
        for (int i = 0;i < 9;i += 3) {
            for (int r = 0;r < 3;r++) {
                System.out.print("|");
                grid[i].printBoardNumber(r);
                grid[i + 1].printBoardNumber(r);
                grid[i + 2].printBoardNumber(r);
                System.out.println();
            }
            System.out.println();
        }
    }

    private void changeTurn() {
        if (currentTurn instanceof X) {
            currentTurn = new O();
        } else if (currentTurn instanceof O) {
            currentTurn = new X();
        }
    }

    private void printCurrentTurn() {
        if (currentTurn instanceof X) {
            ((X) currentTurn).print();
        } else if (currentTurn instanceof O) {
            ((O) currentTurn).print();
        }
    }

    private void setCurrentBoard(int board) {
        changeTurn();
        if (!grid[board - 1].getGameOver()) {
            currentBoard = grid[board - 1];
        } else {
            printBoardNumbers();
            System.out.println("Select board");
            printCurrentTurn();
            board = scan.nextInt();
            while (grid[board - 1].getGameOver()) {
                System.out.println(Color.YELLOW + "BOARD IS OCCUPIED!" + Color.RESET);
                System.out.println("Select board");
                printCurrentTurn();
                board = scan.nextInt();
            }
            currentBoard = grid[board - 1];
        }
        currentBoard.setColor(Color.GREEN);
    }

    private void checkGameOver() {
        for (int i = 0;i < 9;i += 3) {
            if (grid[i].getGameOver() && grid[i + 1].getGameOver() && grid[i + 2].getGameOver()) {
                gameOver = true;
            }
        }
        for (int i = 0;i < 3;i += 1) {
            if (grid[i].getGameOver() && grid[i + 3].getGameOver() && grid[i + 6].getGameOver()) {
                gameOver = true;
            }
        }
        if (grid[4].getGameOver() && grid[0].getGameOver() && grid[8].getGameOver()) {
            gameOver = true;
        } else if (grid[4].getGameOver() && grid[2].getGameOver() && grid[6].getGameOver()) {
            gameOver = true;
        }
    }
}
