package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zangliguang on 2017/6/23.Num202
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " isHappy" + isHappy(i));
        }
    }

    public static boolean isHappy(int n) {
        return getNextNum(n, new HashSet<>()) == 1;
    }

    private static int getNextNum(int n, Set<Integer> set) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        while (n > 0) {
            result += Math.pow((n % 10), 2);
            n /= 10;
        }

        if (result == 1) {
            return 1;
        }
        if (set.contains(result)) {
            return 0;
        }
        set.add(result);
        return getNextNum(result, set);
    }
}
