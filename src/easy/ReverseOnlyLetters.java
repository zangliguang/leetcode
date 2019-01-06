package easy;

/**
 * 917. Reverse Only Letters
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * <p>
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * <p>
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * Note:
 * <p>
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
    }

    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int head = 0, tail = chars.length - 1;
        boolean h = false, t = false;
        while (head < tail) {
            if (!h&&!Character.isAlphabetic(chars[head])) {
                head++;
            } else {
                h = true;
            }
            if (!t&&!Character.isAlphabetic(chars[tail])) {
                tail--;
            } else {
                t = true;
            }
            if (h & t) {
                char tem = chars[head];
                chars[head] = chars[tail];
                chars[tail] = tem;
                h = false;
                t = false;
                head++;
                tail--;
            }

        }
        return String.valueOf(chars);

    }
}
