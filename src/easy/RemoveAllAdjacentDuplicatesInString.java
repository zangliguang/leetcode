package easy;


/**
 * 1047. Remove All Adjacent Duplicates In String
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("aababaab"));
    }

    public static String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int head = 0;
        int tail = 1;
        int length = S.length();
        while (tail < length) {
            if (chars[head] == chars[tail]) {

            } else {
                if (tail - head == 1) {
                    sb.append(chars[head]);

                }
                head = tail;

            }
            tail++;
        }

        if (head == length - 1 && head != 0) {
            sb.append(chars[head]);
        }
        String str = sb.toString();
        if (str.length() == length) {
            return str;
        } else {
            return removeDuplicates(str);
        }

    }
}
