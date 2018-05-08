package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example,
 * Given the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * [[1, 2,3,4],
 * [5, 6,7,8],
 * [9,10,11,12],
 * [13,14,15,16]]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}, new int[]{13, 14, 15, 16}
        };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        setResult(matrix, 0, res);

        return res;
    }

    private static void setResult(int[][] matrix, int index, ArrayList<Integer> res) {
        int widthEnd = matrix[0].length - index - 1;
        int heightEnd = matrix.length - index - 1;
        if (index > widthEnd || index > heightEnd) {
            return;
        }
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        for (int i = index; i <= widthEnd; i++) {
            res.add(matrix[index][i]);
            temp1.add(matrix[heightEnd][widthEnd - (i - index)]);
        }
        int index2 = index + 1;
        for (int i = index2; i < heightEnd; i++) {
            res.add(matrix[i][widthEnd]);
            temp2.add(matrix[heightEnd - (i - index)][index]);
        }
        if (heightEnd > index) {
            res.addAll(temp1);
        }
        if (widthEnd > index) {
            res.addAll(temp2);
        }
        index++;
        setResult(matrix, index, res);

    }
}
