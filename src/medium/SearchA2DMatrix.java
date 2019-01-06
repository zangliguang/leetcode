package medium;

import java.util.Arrays;

/**
 * 74. Search a 2D Matrix
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;

        int column = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[row - 1][column - 1]) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][column - 1] && Arrays.binarySearch(matrix[i], target) >= 0) {
                return true;
            }
        }
        return false;

    }


}
