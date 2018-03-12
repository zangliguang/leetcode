package easy;

/**
 * 479. Largest Palindrome Product
 * Find the largest palindrome made from the product of two n-digit numbers.
 * <p>
 * Since the result could be very large, you should return the largest palindrome mod 1337.
 * <p>
 * Example:
 * <p>
 * Input: 2
 * <p>
 * Output: 987
 * <p>
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 * <p>
 * Note:
 * <p>
 * The range of n is [1,8].
 */
public class LargestPalindromeProduct {

    public int largestPalindrome(int n) {
// 边界处理
        if (n == 1) {
            return 9; // 单位数是回文数
        }
        int maxNumber = (int) Math.pow(10, n) - 1;

        for (int i = maxNumber; i > maxNumber / 10; i--) { // 保证了数值递减
            long num = toLong(i);

            for (long j = maxNumber; j * j >= num; j--) {
                if (num % j == 0) { // num已是回文数，只要mod为0就找到了结果
                    return (int) (num % 1337);
                }
            }
        }
        return 0;
    }

    public long toLong(int number) {

        StringBuffer b = new StringBuffer();
        String str = b.append(number).reverse().toString();

        return Long.valueOf(number + str);
    }
}
