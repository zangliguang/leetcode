package medium;

import java.util.Stack;

/**
 * 678. Valid Parenthesis String
 */
public class ValidParenthesisString {
    public boolean checkValidString2(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
    public boolean checkValidString(String s) {

        Stack<Integer> leftID = new Stack<>();
        Stack<Integer> starID = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                leftID.push(i);
            else if (ch == '*')
                starID.push(i);
            else {
                if (leftID.isEmpty() && starID.isEmpty())   return false;
                if (!leftID.isEmpty())
                    leftID.pop();
                else
                    starID.pop();
            }
        }
        while (!leftID.isEmpty() && !starID.isEmpty()) {
            if (leftID.pop() > starID.pop())
                return false;
        }
        return leftID.isEmpty();

    }
}
