
public class TicTacToe {
    private Space[][] board;
    private Space[][] boardNumber; //used to show the number of the board
    private int gameOver = 0;
    private String color = Color.RESET;

    public TicTacToe(int number) {
        board = new Space[3][3];//3 by 3 array of Space objects (& subclasses)
        boardNumber = new Space[3][3];
        int counter = 1;
        for (int r = 0;r < board.length;r++) {
            for (int c = 0;c < 3;c++) {
                board[r][c] = new Space("" + counter);
                counter++;
            }
        }
        for (int r = 0;r < boardNumber.length;r++) {
            for (int c = 0;c < 3;c++) {
                boardNumber[r][c] = new Space("-");
            }
        }
        boardNumber[1][1] = new Space("" + number);
    }

    public void setColor(String c) {
        color = c;
    }//Setting color of board (green when board is being played)

    public int getGameOver() {
        return gameOver;
    }

    public void printRow(int r) { //printing the rows to visually make everything look like TicTacToe
        for (Space s : board[r]) {
            s.print(color); //this is where Overridden method in X and O objects comes handy
        }
        System.out.print("|" + Color.RESET);
        if (r == 2 && gameOver == 0) {
            color = Color.RESET;
        }
    }

    public void printBoardNumber(int r) {
        if (gameOver == 0) {
            for (Space s : boardNumber[r]) {
                s.print(Color.YELLOW);
            }
            System.out.print("|" + Color.RESET);
        } else {
            printRow(r);
        }
    }

    public void move(int pos, Space space) { //changes Space to X or O object when a player moves
        for (int r = 0;r < 3;r++) {
            for (int c = 0;c < 3;c++) {
                if (board[r][c].getSymbol().equals("" + pos)) {
                    board[r][c] = space;
                    checkWin();
                }
            }
        }
    }

    public boolean canMove(int pos) {
        for (int r = 0;r < 3;r++) {
            for (int c = 0;c < 3;c++) {
                if (board[r][c].getSymbol().equals("" + pos)) {
                    return true;
                }
            }
        }
        System.out.println(Color.YELLOW + "SPACE IS OCCUPIED!" + Color.RESET);
        return false;
    }

    private void checkWin() {
        String center = board[1][1].getSymbol();
        for (int i = 0;i < 3;i++) {
            if (board[0][i].getSymbol().equals(board[1][i].getSymbol())  && board[0][i].getSymbol().equals(board[2][i].getSymbol())) {
                winBoard(board[0][i]);
            } else if (board[i][0].getSymbol().equals(board[i][1].getSymbol()) && board[i][0].getSymbol().equals(board[i][2].getSymbol())) {
                winBoard(board[i][0]);
            }
        }
        if (center.equals(board[0][0].getSymbol()) && center.equals(board[2][2].getSymbol())) {
            winBoard(board[1][1]);
        } else if (center.equals(board[0][2].getSymbol()) && center.equals(board[2][0].getSymbol())) {
            winBoard(board[1][1]);
        }
    }

    private void winBoard(Space s) {
        for (int r = 0;r < board.length;r++) {
            for (int c = 0;c < 3;c++) {
                board[r][c] = s;
            }
        }
        if (s instanceof X) {
            gameOver = 1;
        } else {
            gameOver = 2;
        }
    }
}
