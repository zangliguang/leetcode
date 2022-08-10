package easy;

import java.util.HashMap;

/**
 * 443 String Compression
 */
public class StringCompression {
    public static void main(String[] args) {
        char[]arr=new char[]{'a','a','b','b','c','c','c'};
        System.out.println(compress(arr));
    }
    public static int compress(char[] chars) {

        int[] arr = new int[92];
        for (char aChar : chars) {
            arr[aChar - 35] += 1;
        }
        int result = 0;
        for (int i : arr) {
            if (i != 0) {
                result += 1 + String.valueOf(arr[i]).length();
            }
        }
        return result;
    }
}
