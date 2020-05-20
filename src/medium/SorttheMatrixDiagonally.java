package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1329. Sort the Matrix Diagonally
 * Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.
 */

public class SorttheMatrixDiagonally {
    public static void main(String[] args) {
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        System.out.println("原始数据");
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        diagonalSort(mat);
    }
    public static int[][] diagonalSort(int[][] mat) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int line = mat.length;
        int culumn=mat[0].length;
        for (int i = 0; i < culumn; i++) {
            for (int j = 0; j +i < culumn&&j<line; j++) {
                pq.add(mat[j][j+i]);
            }
            for (int j = 0; j +i < culumn&&j<line; j++) {
                mat[j][i+j]=pq.poll();
            }

        }

        for (int i = 1; i < line; i++) {
            for (int j = 0; j +i < line&&j<culumn; j++) {
                pq.add(mat[j+i][j]);
            }
            System.out.println(pq);
            for (int j = 0; j +i < line&&j<culumn; j++) {
                mat[j+i][j]=pq.poll();
            }
        }
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }

        return mat;
    }
}
