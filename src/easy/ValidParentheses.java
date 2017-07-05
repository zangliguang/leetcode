package easy;

/**
 * Created by zangliguang on 2017/6/29. Num20
 */

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        char s1 = new Character('(');
        char s2 = new Character(')');
        char m1 = new Character('{');
        char m2 = new Character('}');
        char b1 = new Character('[');
        char b2 = new Character(']');
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == s1) {
                stack.push(c);
            }
            if (c == m1) {
                stack.push(c);
            }
            if (c == b1) {
                stack.push(c);
            }
            if (c == s2) {
                if (stack.isEmpty() || stack.pop() != s1) {
                    return false;
                }
            }
            if (c == m2) {
                if (stack.isEmpty() || stack.pop() != m1) {
                    return false;
                }
            }
            if (c == b2) {
                if (stack.isEmpty() || stack.pop() != b1) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
