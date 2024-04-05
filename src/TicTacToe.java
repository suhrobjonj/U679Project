
public class TicTacToe {
    private Space[][] board;
    private Space[][] boardNumber;
    private boolean gameOver = false;
    private String color = Color.RESET;

    public TicTacToe(int number) {
        board = new Space[3][3];
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
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void Move(int pos, Space space) {
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

    public void winBoard(Space s) {
        for (int r = 0;r < board.length;r++) {
            for (int c = 0;c < 3;c++) {
                board[r][c] = s;
            }
        }
        gameOver = true;
    }

    public void printRow(int r) {
        for (Space s : board[r]) {
            s.print(color);
        }
        System.out.print("|" + Color.RESET);
        if (r == 2 && !gameOver) {
            color = Color.RESET;
        }
    }

    public void printBoardNumber(int r) {
        if (!gameOver) {
            for (Space s : boardNumber[r]) {
                s.print(Color.YELLOW);
            }
            System.out.print("|" + Color.RESET);
        } else {
            printRow(r);
        }

    }
}
