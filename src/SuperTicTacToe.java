import java.util.Scanner;

public class SuperTicTacToe {
    private boolean gameOver;
    private TicTacToe currentBoard;
    private Space currentTurn;
    private TicTacToe[] mainBoard;
    public Scanner scan;

    //Constructor
    public SuperTicTacToe () {
        mainBoard = new TicTacToe[9]; //Array of 9 individual TicTacToe objects
        scan = new Scanner(System.in);
        for (int i = 0;i < 9;i++) {
           mainBoard[i] = new TicTacToe(i + 1); //Numbering the objects
        }
    }

    //game logic
    public void play() {
        int pos = 0;
        currentTurn = new O();
        System.out.println("Welcome to Super TicTacToe!");
        printBoardNumbers();
        System.out.print("Select board (1-9): ");
        setCurrentBoard(scan.nextInt());
        while (!gameOver) {
            printMainBoard();
            System.out.println("Select position (1-9): ");
            printCurrentTurn();
            pos = scan.nextInt();
            while (!currentBoard.canMove(pos)) {
                printCurrentTurn();
                pos = scan.nextInt();
            }
            currentBoard.move(pos, currentTurn);
            setCurrentBoard(pos);
            checkGameOver();
        }
        printMainBoard();
        changeTurn();
        currentTurn.print(Color.RESET);
        System.out.print(" WINS!!!");
    }

    private void printMainBoard() {
        for (int i = 0;i < 9;i += 3) {
            for (int r = 0;r < 3;r++) {
                System.out.print("|");
                //printing the rows of the first 3 games on the same line
                mainBoard[i].printRow(r);
                mainBoard[i + 1].printRow(r);
                mainBoard[i + 2].printRow(r);
                System.out.println();
            }
            System.out.println();
        }
    }

    private void printBoardNumbers() {
        for (int i = 0;i < 9;i += 3) {
            for (int r = 0;r < 3;r++) {
                System.out.print("|");
                mainBoard[i].printBoardNumber(r);
                mainBoard[i + 1].printBoardNumber(r);
                mainBoard[i + 2].printBoardNumber(r);
                System.out.println();
            }
            System.out.println();
        }
    }

    //alternate between X and O objects
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

    //setting the next board
    private void setCurrentBoard(int board) {
        changeTurn();
        if (mainBoard[board - 1].getGameOver() == 0) {
            currentBoard = mainBoard[board - 1];
        } else if (!gameOver) {
            printBoardNumbers();
            System.out.println("Select board");
            printCurrentTurn();
            board = scan.nextInt();
            while (mainBoard[board - 1].getGameOver() > 0) {
                System.out.println(Color.YELLOW + "BOARD IS OCCUPIED!" + Color.RESET);
                System.out.println("Select board");
                printCurrentTurn();
                board = scan.nextInt();
            }
            currentBoard = mainBoard[board - 1];
        }
        currentBoard.setColor(Color.GREEN);
    }

    //checking for wins in rows, columns, and diagonals
    private void checkGameOver() {
        for (int i = 0;i < 9;i += 3) {
            if (mainBoard[i].getGameOver() > 0 && mainBoard[i].getGameOver() == mainBoard[i + 1].getGameOver() && mainBoard[i].getGameOver() ==  mainBoard[i + 2].getGameOver()) {
                gameOver = true;
            }
        }
        for (int i = 0;i < 3;i += 1) {
            if (mainBoard[i].getGameOver() > 0 && mainBoard[i].getGameOver() == mainBoard[i + 3].getGameOver() && mainBoard[i].getGameOver() == mainBoard[i + 6].getGameOver()) {
                gameOver = true;
            }
        }
        if (mainBoard[4].getGameOver() > 0 && mainBoard[4].getGameOver() == mainBoard[0].getGameOver() && mainBoard[4].getGameOver() == mainBoard[8].getGameOver()) {
            gameOver = true;
        } else if (mainBoard[4].getGameOver() > 0 && mainBoard[4].getGameOver() == mainBoard[2].getGameOver() && mainBoard[4].getGameOver() == mainBoard[6].getGameOver()) {
            gameOver = true;
        }
    }
}
