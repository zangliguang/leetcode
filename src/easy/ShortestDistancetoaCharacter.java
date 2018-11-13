package easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Shortest Distance to a Character
 * num821
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * <p>
 * <p>
 * Note:
 * <p>
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */
public class ShortestDistancetoaCharacter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("aaab", 'b')));
    }

    public static int[] shortestToChar(String S, char C) {
        int length = S.length();
        int[] result = new int[length];
        ArrayList<Integer> list = new ArrayList<>();
        int index = S.indexOf(C);
        while (index != -1) {
            list.add(index);
            index = S.indexOf(C, index + 1);
        }
        int arrayHead = 0;
        Integer head = list.get(0);
        Integer tail = head;
        for (int i = 0; i < list.size() - 1; i++) {
            head = list.get(i);
            tail = list.get(i + 1);

            for (int j = arrayHead; j < tail; j++) {
                result[j] = Math.min(Math.abs(j - head), Math.abs(j - tail));
            }
            arrayHead = tail;
        }
        if (tail.equals(head)) {
            for (Integer i = 0; i < head; i++) {
                result[i] = head - i;
            }
        }
        for (int i = tail + 1; i < length; i++) {
            result[i] = i - tail;
        }
        return result;


    }
}
