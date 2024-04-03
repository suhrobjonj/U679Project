
public class TicTacToe {
    private Space[][] grid;
    private String occupier = "0";
    private String color = Color.RESET;

    public TicTacToe() {
        grid = new Space[3][3];
        int counter = 1;
        for (int r = 0;r < grid.length;r++) {
            for (int c = 0;c < 3;c++) {
                grid[r][c] = new Space("" + counter);
                counter++;
            }
        }
    }

    public void setColor(String c) {
        color = c;
    }

    public boolean Move(int pos, String symbol) {
        for (int r = 0;r < 3;r++) {
            for (int c = 0;c < 3;c++) {
                if (grid[r][c].getSymbol().equals("" + pos)) {
                    grid[r][c].setSymbol(symbol);
                    checkWin();
                }
            }
        }
        return false;
    }

    private boolean checkWin() {
        for (int i = 0;i < 3;i++) {
            if (grid[0][i].getSymbol().equals(grid[1][i].getSymbol())  && grid[0][i].getSymbol().equals(grid[2][i].getSymbol())) {
                return true;
            } else if (grid[i][0].getSymbol().equals(grid[i][1].getSymbol()) && grid[i][0].getSymbol().equals(grid[i][2].getSymbol())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void printGrid() {
        for (Space[] row : grid) {
            for (Space s : row) {
                System.out.print(s.getSymbol());
            }
            System.out.println();
        }
    }

    public void printRow(int r) {
        for (Space s : grid[r]) {
            if (s.getSymbol().equals("X")) {
                System.out.print(Color.BLUE + " " + s.getSymbol() + " " + Color.RESET);
            } else if (s.getSymbol().equals("0")) {
                System.out.print(Color.RED + " " + s.getSymbol() + " " + Color.RESET);
            } else {
                System.out.print(color + " " + s.getSymbol() + " " + Color.RESET);
            }
        }
        System.out.print("|");
        if (r == 2) {
            color = Color.RESET;
        }
    }
}
