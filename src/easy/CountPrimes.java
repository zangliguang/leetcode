package easy;

/**
 * Created by zangliguang on 2017/6/29. Num204
 */

import java.util.Arrays;

/**
 * Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(3));
        System.out.println(countPrimes(5));
        System.out.println(countPrimes(6));
        System.out.println(countPrimes(7));
        System.out.println(countPrimes(8));
    }

    public static int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        int result = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 2; i * j < n; j++) {
                prime[i * j] = false;
            }
            if (prime[i]) {
                result++;
            }
        }
        return result;
    }
}
