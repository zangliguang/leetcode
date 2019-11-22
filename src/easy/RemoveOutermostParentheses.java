package easy;

/**
 * 1021. Remove Outermost Parentheses
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * <p>
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 * <p>
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * <p>
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 * <p>
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 * <p>
 * <p>
 * Note:
 * <p>
 * S.length <= 10000
 * S[i] is "(" or ")"
 * S is a valid parentheses string
 */
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {

                if (sum > 0) {
                    sb.append(chars[i]);
                }
                sum++;
            }
            if (chars[i] == ')') {
                sum--;
                if (sum > 0) {
                    sb.append(chars[i]);
                }
            }
        }
        return sb.toString();

    }
}
