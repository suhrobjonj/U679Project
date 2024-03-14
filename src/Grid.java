public class Grid {
    private String[][] grid;

    public Grid() {
        grid = new String[13][13];
        for (int r = 0;r < grid.length;r++) {
            for (int c = 0;c < grid[0].length;c++) {
                if (r % 4 == 0) {
                    grid[r][c] = " - ";
                } else if (c % 4 == 0) {
                    grid[r][c] = "|";
                }
            }
        }
        for (String[] row : grid) {
            for (String g : row) {
                System.out.print(g);
            }
            System.out.println();
        }
    }
}
