package easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1356. Sort Integers by The Number of 1 Bits
 */
public class SortIntegersbyTheNumberof1Bits {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(i -> Integer.bitCount(i) * 10000 + i)).mapToInt(i -> i).toArray();
    }
}
