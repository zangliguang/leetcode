package easy;

import java.util.Arrays;

/**
 * 1051. Height Checker
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * <p>
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] height2 = heights.clone();
        Arrays.sort(height2);
        int result = 0;
        for (int i = 0; i < height2.length; i++) {
            result += heights[i] != height2[i] ? 1 : 0;
        }
        return result;
    }
}
