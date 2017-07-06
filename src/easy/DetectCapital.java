package easy;

/**
 * Created by zangliguang on 2017/7/6.Num520
 */

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * <p>
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * <p>
 * Example 1:
 * <p>
 * Input: "USA"
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input: "FlaG"
 * Output: False
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        char first = word.charAt(0);
        boolean result = isBiger(first);
        boolean allBiger = true;
        boolean allSmall = true;
        char[] chars = word.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            allBiger &= isBiger(chars[i]);
            allSmall &= !isBiger(chars[i]);
        }
        return (allBiger&result) || allSmall;

    }

    private boolean isBiger(char first) {
        return first >= 'A' && first <= 'Z';
    }
}
