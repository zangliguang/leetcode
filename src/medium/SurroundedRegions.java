package medium;

/**
 * 130. Surrounded Regions
 * <p>
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Notice that an 'O' should not be flipped if:
 * - It is on the border, or
 * - It is adjacent to an 'O' that should not be flipped.
 * The bottom 'O' is on the border, so it is not flipped.
 * The other three 'O' form a surrounded region, so they are flipped.
 */
public class SurroundedRegions {
    public static void main(String[] args) {

    }

    public void solve(char[][] board) {

        int height = board.length;
        int width = board[0].length;
        int[][] copyArray = new int[height][width];

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                copyArray[i][j] = board[i][j] == 'O' ? 1 : 0;
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (copyArray[i][j] == 1) {
                    if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                        copyArray[i][j] = -1;
                        dfsCopyArray(copyArray, i, j);


                    }
                }
            }
        }
        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < width - 1; j++) {
                if (copyArray[i][j] == 1) {
                    board[i][j]='X';
                }
            }
        }


    }

    private void dfsCopyArray(int[][] copyArray, int i, int j) {
        int height = copyArray.length;
        int width = copyArray[0].length;
        if (i > 0 && copyArray[i - 1][j] == 1) {
            copyArray[i - 1][j] = -1;
            dfsCopyArray(copyArray,i-1,j);
        }
        if (j > 0 && copyArray[i][j - 1] == 1) {
            copyArray[i][j - 1] = -1;
            dfsCopyArray(copyArray,i,j-1);
        }
        if (i < height - 1 && copyArray[i + 1][j] == 1) {
            copyArray[i + 1][j] = -1;
            dfsCopyArray(copyArray,i+1,j);
        }
        if (j < width - 1 && copyArray[i][j + 1] == 1) {
            copyArray[i][j + 1] = -1;
            dfsCopyArray(copyArray,i,j+1);
        }
    }
}
