package medium;

/**
 * 794. Valid Tic-Tac-Toe State
 */
public class ValidTicTacToeState {
    public static void main(String[] args) {
        System.out.println(validTicTacToe(new String[]{"X O","   ","   "}));
    }
    public static boolean validTicTacToe(String[] board) {
        int xnum = 0;
        int onum = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') {
                    xnum++;
                } else if (c == 'O') {
                    onum++;
                }
            }

        }
        if (onum > xnum || xnum - onum >= 2) {
            return false;
        }

        String s1 = board[0];
        String s2 = board[1];
        String s3 = board[2];
        Character win = ' ';
        if (s1.charAt(0) == s1.charAt(1) && s1.charAt(0) == s1.charAt(2)&&s1.charAt(0)!=' ') {
            win = s1.charAt(0);
        }
        if (s2.charAt(0) == s2.charAt(1) && s2.charAt(0) == s2.charAt(2)&&s2.charAt(0)!=' ') {
            if (win!=' '&&win!=s2.charAt(0)) {
                return false;
            }
            win = s2.charAt(0);
        }
        if (s3.charAt(0) == s3.charAt(1) && s3.charAt(0) == s3.charAt(2)&&s3.charAt(0)!=' ') {
            if (win!=' '&&win!=s3.charAt(0)) {
                return false;
            }
            win = s3.charAt(0);
        }
        if (s1.charAt(0) == s2.charAt(0) && s1.charAt(0) == s3.charAt(0)&&s1.charAt(0)!=' ') {
            if (win!=' '&&win!=s1.charAt(0)) {
                return false;
            }
            win = s1.charAt(0);

        }
        if (s1.charAt(1) == s2.charAt(1) && s1.charAt(1) == s3.charAt(1)&&s2.charAt(1)!=' ') {
            if (win!=' '&&win!=s1.charAt(2)) {
                return false;
            }
            win = s1.charAt(1);
        }
        if (s1.charAt(2) == s2.charAt(2) && s1.charAt(2) == s3.charAt(2)&&s2.charAt(2)!=' ') {
            if (win!=' '&&win!=s1.charAt(2)) {
                return false;
            }
            win = s1.charAt(2);
        }
        if (s1.charAt(0) == s2.charAt(1) && s1.charAt(0) == s3.charAt(2)&&s2.charAt(1)!=' ') {
            if (win!=' '&&win!=s1.charAt(0)) {
                return false;
            }
            win = s1.charAt(0);
        }
        if (s1.charAt(2) == s2.charAt(1) && s1.charAt(2) == s3.charAt(0)&&s2.charAt(1)!=' ') {
            if (win!=' '&&win!=s1.charAt(2)) {
                return false;
            }
            win = s1.charAt(2);
        }
        if (win == 'X') {
            return xnum == onum + 1;
        }
        if (win == 'O') {
            return xnum == onum;
        }
        return true;

    }


}
