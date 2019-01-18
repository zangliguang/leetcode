package medium;

/**
 * 73. Set Matrix Zeroes
 * <p>
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * Example 2:
 * <p>
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * Follow up:
 * <p>
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * Accepted
 * 181,192
 * Submissions
 * 470,355
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = -1, column = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    column = j;


                }
            }

        }
        if (row == -1) {
            return;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0 && i != row && j != column) {
                    matrix[i][columns] = 0;
                    matrix[row][j] = 0;
                }
            }
        }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
            {
                if (i != row && j != column)
                {
                    if (matrix[i][column] == 0 )
                        matrix[i][j] = 0;
                    else if (matrix[row][j] == 0)
                        matrix[i][j] = 0;
                }
            }
        int index = -1;
        while(++index < rows) matrix[index][column] = 0;
        index = -1;
        while(++index < rows) matrix[row][index] = 0;
    }
}
