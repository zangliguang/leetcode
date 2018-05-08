package medium;

/**
 * 343. Integer Break
 * <p>
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * <p>
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        if (n == 4) return 4;
        boolean condition = n % 3 == 1;


        return (int) (Math.pow(3, (condition ? (n / 3 - 1) : (n / 3)))*(condition?4:2));
    }
}
