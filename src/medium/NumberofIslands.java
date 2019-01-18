package medium;

/**
 * 200. Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberofIslands {

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    setValue(grid, i, j);

                    result++;
                }
            }
        }


        return result;
    }

    private void setValue(char[][] grid, int i, int j) {
        if (i > 0 && grid[i - 1][j] == '1') {
            grid[i - 1][j] = '2';
            setValue(grid, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            grid[i + 1][j] = '2';
            setValue(grid, i + 1, j);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
            grid[i][j + 1] = '2';
            setValue(grid, i, j + 1);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            grid[i][j - 1] = '2';
            setValue(grid, i, j - 1);
        }
    }


}
