package easy;

/**
 * Created by zangliguang on 2017/8/15.Num657
 */

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 * <p>
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 * <p>
 * Example 1:
 * <p>
 * Input: "UD"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: "LL"
 * Output: false
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {

        int LNum = 0;
        int RNum = 0;
        int UNum = 0;
        int DNum = 0;
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'L':
                    LNum++;
                    break;
                case 'R':
                    RNum++;
                    break;
                case 'D':
                    DNum++;
                    break;
                case 'U':
                    UNum++;
                    break;
                default:
                    break;
            }
        }
        return LNum == RNum && DNum == UNum;

    }
}
