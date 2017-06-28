package easy;

/**
 * Created by zangliguang on 2017/6/23.Num463
 */

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * Example:
 * <p>
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    result += 4;

                    if (i > 0 && grid[i - 1][j] == 1) {
                        result--;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        result--;
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        result--;
                    }
                    if (j < row.length - 1 && grid[i][j + 1] == 1) {
                        result--;
                    }
                }
            }
        }
        return result;

    }
}
