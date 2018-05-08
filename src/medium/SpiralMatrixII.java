package medium;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II
 * <p>
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * For example,
 * Given n = 3,
 * <p>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3,4 ],
 * [ 12, 13,14,5 ],
 * [ 11, 16, 15,6 ]
 * [ 10, 9, 8,7 ]
 * ]
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        printMatrix(1);
        printMatrix(2);
        printMatrix(9);
    }

    private static void printMatrix(int n) {
        int[][] ints = generateMatrix(n);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
        System.out.println("=====================");
    }

    public static int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][];
        }
        int[][] matrix = new int[n][n];

        setMatrixByTimes(matrix, 0, 1);
        return matrix;

    }

    private static void setMatrixByTimes(int[][] matrix, int times, int start) {
        int length = matrix.length;
        if (times * 2 > length) {
            return;
        }
        int end = length - times;

        for (int i = times; i < end; i++) {
            matrix[times][i] = start;
            matrix[end - 1][end - 1 - (i - times)] = start + (end - 1 - times) * 2;
            start++;

        }
        end--;
        for (int i = times + 1; i < end; i++) {
            matrix[i][end] = start;
            matrix[end - (i - times)][times] = start + (end - times) * 2;
            start++;
        }

        if (times + 1 >= length) {
            return;
        }

        setMatrixByTimes(matrix, times + 1, matrix[times + 1][times] + 1);
    }
}
