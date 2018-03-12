package medium;

/**
 * Created by zangliguang on 2017/6/15. Num79
 */

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class WordSearch {
    public static void main(String[] args) {

        boolean abcced = exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "SEE");
        System.out.println(abcced);
    }

    public static boolean exist(char[][] board, String word) {

        int height = board.length;
        for (int i = 0; i < height; i++) {
            int width = board[0].length;
            for (int j = 0; j < width; j++) {
                if (exist(board, i, j, word, 0))
                    return true;
            }
        }
        return false;

    }

    private static boolean exist(char[][] board, int i, int j, String word, int ind) {
        if (ind == word.length()) return true;
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
            return false;
        board[i][j] = '*';
        boolean result = exist(board, i - 1, j, word, ind + 1) ||
                exist(board, i, j - 1, word, ind + 1) ||
                exist(board, i, j + 1, word, ind + 1) ||
                exist(board, i + 1, j, word, ind + 1);
        board[i][j] = word.charAt(ind);
        return result;
    }

}
