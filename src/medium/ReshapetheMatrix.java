package medium;

/**
 * Created by zangliguang on 2017/6/13. Num566
 */

/**
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * <p>
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * <p>
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 * [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * <p>
 * Note:
 * <p>
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 */
public class ReshapetheMatrix {

    public static void main(String[] args) {

    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int original_r = nums.length;
        int original_c = nums[0].length;
        if (original_r * original_c == r * c) {
            int[][] result = new int[r][c];
            for (int i = 0; i < r * c; i++) {
                result[i / c][i % c] = nums[i / original_c][i % original_c];
            }
            return result;
        } else {
            return nums;
        }
    }
}
