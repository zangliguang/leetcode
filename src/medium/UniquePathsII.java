package medium;

/**
 * 63. Unique Paths II
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 */
public class UniquePathsII {

    public static void main(String[] args) {
        System.out.println(1 ^ 0);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] map = new Integer[m][n];
        map[0][0] = 1;
        for (int i = 1; i < m; i++) {
            map[i][0] = (1 ^ obstacleGrid[i][0]) & map[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            map[0][j] = (1 ^ obstacleGrid[0][j]) & map[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = (map[i - 1][j] + map[i][j - 1]) * (obstacleGrid[i][j] ^ 1);
            }
        }
        return map[m - 1][n - 1];
    }
}
