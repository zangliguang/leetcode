package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * num728
 * A self-dividing number is a number that is divisible by every digit it contains.
 * <p>
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * <p>
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * <p>
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * <p>
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * <p>
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class SelfDividingNumbers {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        right += 1;
        for (int i = left; i < right; i++) {
            if (isSelfDividerNum(i)) {
                result.add(i);
            }

        }
        return result;
    }

    private static boolean isSelfDividerNum(int num) {
        int temp = num;
        while (temp > 0) {
            int remainder = temp % 10;
            if (remainder == 0 || num % remainder > 0) {
                return false;
            }
            temp = (temp - remainder) / 10;

        }
        return true;
    }
}
