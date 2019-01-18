package easy;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 509. Fibonacci Number
 * <p>
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 * <p>
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 * <p>
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 ≤ N ≤ 30.
 * <p>
 * Accepted
 * 5,510
 * Submissions
 * 8,126
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    public static int fib(int N) {
        if (N <= 1) {
            return N;
        } else {
            ArrayList<Integer> list = new ArrayList();
            list.add(0);
            list.add(1);


            for (int i = 2; i <= N; i++) {
                list.add(list.get(list.size() - 2) + list.get(list.size() - 1));
            }

            return list.get(list.size() - 1);
        }

    }


}
