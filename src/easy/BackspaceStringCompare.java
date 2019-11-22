package easy;

import java.util.Stack;

/**
 * 844. Backspace String Compare
 * <p>
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * <p>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * <p>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * <p>
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * <p>
 * Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        if (S.equals(T)) {
            return true;
        }

        Stack<Character> stackA = new Stack<>();
        char[] charA = S.toCharArray();
        Stack<Character> stackB = new Stack<>();
        char[] charB = T.toCharArray();


        setStacvk(stackA, charA);
        setStacvk(stackB, charB);


        if (stackA.size() != stackB.size()) {
            return false;
        }
        while (!stackA.isEmpty()) {
            if (stackA.pop() != stackB.pop()) {
                return false;
            }
        }
        return true;


    }

    private void setStacvk(Stack<Character> stackA, char[] charA) {
        for (int i = 0; i < charA.length; i++) {
            char item = charA[i];
            if (item == '#') {
                if (!stackA.empty()) {
                    stackA.pop();
                }
            } else {
                stackA.push(item);
            }
        }
    }
}
