package medium;

/**
 * Created by zangliguang on 2017/6/13.
 */

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * <p>
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * <p>
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsinaStringIII {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            split[i] = new StringBuffer(split[i]).reverse().toString();
            sb.append(split[i]);
            if (i < split.length - 1) {
                sb.append(" ");
            }

        }
        return sb.toString();


    }


}
