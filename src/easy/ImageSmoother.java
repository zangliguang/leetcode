package easy;

import java.util.ArrayList;

/**
 * 661. Image Smoother
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 */
public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        int with = M[0].length;
        int height = M.length;
        int[][] N = new int[height][with];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (i > 0 && i < height - 1 && j > 0 && j < with - 1) {
                    N[i][j] = (M[i][j] + M[i - 1][j] + M[i - 1][j - 1] + M[i - 1][j + 1] + M[i][j + 1] + M[i][j - 1] + M[i + 1][j] + M[i + 1][j + 1] + M[i + 1][j - 1]) / 9;
                }
                int count = 1, sum = M[i][j];
                if (i > 0) {
                    count++;
                    sum += M[i - 1][j];
                    if (j > 0) {
                        count++;
                        sum += M[i - 1][j - 1];
                    }
                    if (j < with - 1) {
                        count++;
                        sum += M[i - 1][j + 1];
                    }
                }
                if (i < height - 1) {
                    count++;
                    sum += M[i + 1][j];
                    if (j > 0) {
                        count++;
                        sum += M[i + 1][j - 1];
                    }
                    if (j < with - 1) {
                        count++;
                        sum += M[i + 1][j + 1];
                    }
                }
                if (j > 0) {
                    count++;
                    sum += M[i][j - 1];
                }
                if (j < with - 1) {
                    count++;
                    sum += M[i][j + 1];
                }
                N[i][j] = sum / count;

            }
        }
        return N;
    }
}
