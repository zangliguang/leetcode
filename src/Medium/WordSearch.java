package Medium;

/**
 * Created by zangliguang on 2017/6/15. Num79
 */

import java.sql.Array;
import java.util.*;

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



        return true;
    }


}
