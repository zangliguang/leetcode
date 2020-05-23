package medium;

/**
 * 1277 Count Square Submatrices with All Ones
 */
public class CountSquareSubmatriceswithAllOnes {
    public static void main(String[] args) {
        int[][] N = {
       {0, 1, 1, 1},
       {1, 1, 1, 1},
       {0, 1, 1, 1}};
        int[][] M = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 1, 0},
                {1, 1, 1},
                {1, 1, 0}
        };
        System.out.println(countSquares(N));
    }

    public static int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 1) {
                    result++;
                    int size = Math.min(r - i - 1, c - j - 1);
                    boolean isSquare;
                    for (int k = 1; k <= size; k++) {
                        isSquare = true;
                        for (int l = j; l <= j + k; l++) {
                            if (matrix[i + k][l] != 1) {
                                isSquare = false;
                                break;
                            }
                        }
                        if (!isSquare) {
                            break;
                        }
                        for (int l = i; l <= i + k; l++) {
                            if (matrix[l][k + j] != 1) {
                                isSquare = false;
                                break;
                            }
                        }
                        if (!isSquare) {
                            break;
                        }
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
