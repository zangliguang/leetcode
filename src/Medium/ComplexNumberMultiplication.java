package Medium;

import java.util.Arrays;

/**
 * num537
 * <p>
 * Given two strings representing two complex numbers.
 * <p>
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * <p>
 * Example 1:
 * <p>
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * <p>
 * Example 2:
 * <p>
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * <p>
 * Note:
 * <p>
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        System.out.println( complexNumberMultiply("1+1i", "1+1i"));

    }

    public static String complexNumberMultiply(String a, String b) {
        String[] strA = a.split("\\+");
        String[] strB = b.split("\\+");
        Integer a1 = Integer.valueOf(strA[0]);
        Integer b1 = Integer.valueOf(strB[0]);
        Integer a2 = Integer.valueOf(strA[1].substring(0, strA[1].length() - 1));
        Integer b2 = Integer.valueOf(strB[1].substring(0, strB[1].length() - 1));
        return a1 * b1 - b2 * a2 + "+" + (a1 * b2 + a2 * b1) + "i";
    }
}
