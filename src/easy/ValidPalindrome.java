package easy;


/**
 * 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Race a car"));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int tail = s.length() - 1;
        int head = 0;
        char[] chars = s.toCharArray();
        while (head < tail) {
            char hc = chars[head];
            char tc = chars[tail];
            if (!Character.isLetterOrDigit(hc)) {
                head++;
                continue;
            } else if (!Character.isLetterOrDigit(tc)) {
                tail--;
                continue;
            }
            if (hc == tc) {
                head++;
                tail--;
            } else {
                return false;
            }
        }
        return true;
    }
}
