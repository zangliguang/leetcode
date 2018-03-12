package easy;

/**
 * 788. Rotated Digits
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X. A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number.
 * <p>
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * <p>
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 * <p>
 * N  will be in range [1, 10000].
 * 0,1,2,5,6,8,9,
 */
public class RotatedDigits {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
    }

    public static int rotatedDigits(int N) {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (isGood(i)) {
                result++;
            }
        }
        return result;

    }

    private static boolean isGood(int num) {
        boolean validFound = false;
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '3' || chars[i] == '4' || chars[i] == '7') {
                return false;
            }
            if (chars[i] == '2' || chars[i] == '5' || chars[i] == '6' || chars[i] == '9') {
                validFound = true;
            }

        }
        return validFound;
    }

}
