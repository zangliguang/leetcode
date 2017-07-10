package easy;

/**
 * Created by zangliguang on 2017/7/10.Num171
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        for (int i = 1; i < 40; i++) {

            System.out.println(convertToTitle(i));
        }
    }

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n >= 1) {
            n--;
            sb.insert(0, (char) ('A' + n % 26));
            n /= 26;

        }
        return sb.toString();

    }
}
