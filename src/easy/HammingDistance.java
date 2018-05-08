package easy;

/**
 * Created by zangliguang on 2017/6/11.  Num 461
 */

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * 0 ≤ x, y < 231.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
    public static void main(String[] args) {
        //469
        System.out.println(hammingDistance_compareByXOR(1, 4));
    }


    public static int hammingDistance_compareByStr(int x, int y) {

        //compare by str

        String strLong = Integer.toBinaryString(Math.max(x, y));
        String strShort = Integer.toBinaryString(Math.min(x, y));
        int result = 0;
        char cc = '1';

        int basicLength = strShort.length();
        for (int i = 0; i < strLong.length() - basicLength; i++) {
            if (strLong.charAt(i) == cc) {
                result++;
            }
        }
        strLong = strLong.substring(strLong.length() - basicLength);
        for (int j = 0; j < basicLength; j++) {
            if (strLong.charAt(j) != strShort.charAt(j)) {
                result++;
            }
        }


        return result;


    }

    public static int hammingDistance_compareByXOR(int x, int y) {

        //compare by str

        int result = 0;
        int xor = x ^ y;
        while (xor != 0) {
            result += xor % 2;
            xor /= 2;
        }
        return result;

    }
}
