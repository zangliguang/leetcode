package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels
 * <p>
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 * <p>
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 * Accepted
 * 32,606
 * Submissions
 * 48,354
 */
public class PartitionLabels {
    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int end = S.lastIndexOf(c);
            for (int j = i + 1; j < end; j++) {
                if (S.lastIndexOf(S.charAt(j)) > end) {
                    end = S.lastIndexOf(S.charAt(j));
                }
            }
            result.add(end - i+1);
            i = end;
        }
        return result;


    }
}
