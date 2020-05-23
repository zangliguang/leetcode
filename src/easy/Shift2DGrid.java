package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. Shift 2D Grid
 */
public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int i = 0; i < k; i++) {
            shiftonce(grid);
        }
        List<List<Integer>> result = new ArrayList<>();
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                list.add(grid[i][j]);
            }
            result.add(list);
        }
        return result;
    }

    private void shiftonce(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] arr = new int[r];
        for (int j = 1; j < r; j++) {
            arr[j] = grid[j - 1][c - 1];
        }
        arr[0] = grid[r-1][c - 1];
        for (int i = 0; i < r; i++) {
            for (int j = c - 1; j > 0; j--) {
                grid[i][j] = grid[i][j - 1];
            }
            grid[i][0] = arr[i];
        }
    }
}
