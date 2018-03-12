package medium;

/**
 * Created by zangliguang on 2017/6/14. Num264
 */

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * <p>
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 * <p>
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        SortedSet<Long> s1 = new TreeSet<>();
        s1.add((long) 1);
        long result = s1.first();
        for (int i = 0; i < n; i++) {
            result = s1.first();
            s1.add(result * 2);
            s1.add(result * 3);
            s1.add(result * 5);
            s1.remove(result);
        }
        return (int) result;
    }


}
