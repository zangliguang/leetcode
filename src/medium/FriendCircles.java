package medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 547. Friend Circles
 */
public class FriendCircles {
    public static void main(String[] args) {
        int[][] M = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};
        int[][] N = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        System.out.println(findCircleNum(M));
    }

    public static int findCircleNum(int[][] M) {
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    markVisited(M, i, j);
                    count++;
                }

            }
        }
        return count;

    }

    private static void markVisited(int[][] M, int i, int j) {
        int row = M.length;
        int column = M[0].length;
        if (i == row||j == column||M[i][j] != 1) {
            return;
        }
        M[i][j] = -1;
        for (int c = 0; c < column; c++) {

            if (M[i][c] == 1) {
                markVisited(M,i,c);
            }
        }
        for (int r = 0; r < row; r++) {
            if (M[r][j] == 1) {
                markVisited(M,r,j);
            }
        }
    }


    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
