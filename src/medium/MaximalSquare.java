package medium;

/**
 * num221
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {


                result = Math.max(result, getImal(matrix, i, j));
            }
        }
        return result * result;

    }

    private int getImal(char[][] matrix, int i, int j) {

        if (matrix[i][j] == '0') {
            return 0;
        }
        int imal = 1;
        int originY=i;
        int originX=j;
        boolean flag = i < matrix.length - 1 && j < matrix[i].length - 1;
        while (flag) {



            for (int k = originX; k <= j + 1; k++) {
                if (matrix[i + 1][k] == '0') {
                    return imal;
                }
            }
            for (int k = originY; k <= i + 1; k++) {
                if (matrix[k][j + 1] == '0') {
                    return imal;
                }
            }

            imal++;
            i++;
            j++;
            if (i == matrix.length - 1 || j == matrix[i].length - 1) {
                return imal;

            }
        }
        return imal;
    }
}
