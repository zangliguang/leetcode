package medium;

import java.util.Collections;

/**
 * 240. Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }

        int height = matrix.length;
        int width = matrix[0].length;
        int i = 0;
        int j = width - 1;
        while ( i < height&&j >= 0) {
                if(matrix[i][j]==target){
                    return true;
                }
                if(matrix[i][j]>target){
                    j--;
                }else{
                    i++;
                }
            }
        return false;
    }
}
