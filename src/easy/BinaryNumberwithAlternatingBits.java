package easy;

/**
 * num693
 * <p>
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 * <p>
 * Example 2:
 * <p>
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 * <p>
 * Example 3:
 * <p>
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 * <p>
 * Example 4:
 * <p>
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 */
public class BinaryNumberwithAlternatingBits {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(7));
    }

    public boolean hasAlternatingBits(int n) {
        return Integer.toBinaryString(n).matches("(10)*1{0,1}");
    }

    public boolean hasAlternatingBits2(int n) {
        int pre;
        pre = n & 1;
        n = n >> 1;
        while (n != 0) {
            int cur = n & 1;
            if (pre + cur != 1) return false;
            pre = cur;
            n = n >> 1;
        }
        return true;
    }
}
