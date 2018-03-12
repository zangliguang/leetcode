package easy;

/**
 * 38. Count and Say
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class CountandSay {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(i + ":" + countAndSay(i).equals(countAndSay2(i)));
        }

    }

    public static String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);

            for (int j = 1, len = prev.length(); j < len; j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();

    }

    public static String countAndSay2(int n) {
        if (n <= 1) {
            return "1";
        }
        String pre = countAndSay2(n - 1);
        char[] chars = pre.toCharArray();
        Character cc = chars[0];
        int count = 1;
        StringBuilder curr = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cc) {
                count++;
            } else {
                curr.append(count);
                curr.append(cc);
                cc = chars[i];
                count = 1;
            }
        }
        curr.append(count);
        curr.append(cc);
        return curr.toString();

    }
}
