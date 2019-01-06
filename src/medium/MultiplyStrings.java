package medium;

import java.util.ArrayList;

/**
 * 43. Multiply Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * <p>
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("123456789", "987654321"));
//        System.out.println(multiply("12", "12"));
    }

    public static String multiply(String num1, String num2) {
        if (num2.equals("0") || num1.equals("0")) {
            return "0";
        }
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        if (num2.length() > num1.length()) {
            return multiply(num2, num1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = char2.length - 1; j >= 0; j--) {

            for (int i = char1.length - 1; i >= 0; i--) {
                int index = char1.length + char2.length - j - i - 2;
                if (list.size() <= index) {
                    list.add((char2[j] - '0') * (char1[i] - '0'));
                } else {
                    list.set(index, list.get(index) + (char2[j] - '0') * (char1[i] - '0'));
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > 9) {
                list.set(i + 1, list.get(i + 1) + list.get(i) / 10);
                list.set(i, list.get(i) % 10);
            }
        }
        System.out.println(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        return sb.toString();

    }
}
