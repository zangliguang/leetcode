package medium;

/**
 * Created by zangliguang on 2017/6/13.Num338
 */

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * <p>
 * Credits:
 * Special thanks to @ syedee for adding this problem and creating all test cases.
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class CountingBits {

    public static void main(String[] args) {

    }

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = getBits(i);
        }
        return result;

    }

    public static int[] countBits2(int num) {
        int[] result = new int[num + 1];
        result[1] = 1;
        for (int i = 0; i <= num; i++) {
            result[i] = result[i / 2] + i % 2;
        }
        return result;

    }

    private static int getBits(int i) {
        int res = 0;
        while (i > 0) {
            res += i % 2;
            i = i >> 1;
        }
        return res;
    }
}
