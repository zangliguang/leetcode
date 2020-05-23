package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

/**
 * 1380. Lucky Numbers in a Matrix
 */
public class LuckyNumbersinaMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int min, index;
        int rn = matrix.length;
        int cn = matrix[0].length;
        boolean max;
        for (int i = 0; i < rn; i++) {
            min = Integer.MAX_VALUE;
            index = -1;
            max = true;
            for (int j = 0; j < cn; j++) {

                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    index = j;
                }
            }

            for (int j = 0; j < rn; j++) {
                if (matrix[j][index] > min) {
                    max = false;
                    break;
                }
            }
            if (max) {
                result.add(matrix[i][index]);
            }

        }
        return result;
    }
}

