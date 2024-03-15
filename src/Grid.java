

public class Grid {
    private Space[][] grid;

    public Grid() {
        int counter = 1;
        int current = 1;
        grid = new Space[3][13];
        for (int r = 0;r < grid.length;r++) {
            for (int c = 0;c < grid[0].length;c++) {
                if (c % 4 == 0) {
                    grid[r][c] = new Space("|");
                } else {
                    grid[r][c] = new Space(" " + counter + " ");
                    counter++;
                    if (counter - current == 3) {
                        counter = current;
                    }
                }
            }
            current += 3;
            counter = current;
        }

        Space[][] row1 = grid;
        Space[][] row2 = grid;
        Space[][] row3 = grid;

        for (Space[] row : row1) {
            for (Space s : row) {
                System.out.print(s.getSymbol());
            }
            System.out.println();
        }
        System.out.println();
        for (Space[] row : row2) {
            for (Space s : row) {
                System.out.print(s.getSymbol());
            }
            System.out.println();
        }
        System.out.println();
        for (Space[] row : row3) {
            for (Space s : row) {
                System.out.print(s.getSymbol());
            }
            System.out.println();
        }

    }
}
