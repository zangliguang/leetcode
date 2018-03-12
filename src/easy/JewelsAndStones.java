package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        char[] chars = J.toCharArray();
        for (char aChar : chars) {
            set.add(aChar);
        }
        char[] sc = S.toCharArray();
        for (char c : sc) {
            count += set.contains(c) ? 1 : 0;
        }
        return count;
    }
}
