package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number
 * <p>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * <p>
 * Seen this question in a real interview before?
 */
public class LargestNumber {

    public String largestNumber(Integer[] nums) {
        String[] ar = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ar[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ar, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        if(ar[0].equals("0"))return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ar.length; i++) {
            sb.append(ar[i]);
        }
        return sb.toString();
    }
}
