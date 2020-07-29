package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 1502 Can Make Arithmetic Progression From Sequence
 */
public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int space = temp[1] - temp[0];
        for (int i = 2; i < temp.length; i++) {
            if (temp[i] - temp[i - 1] != space) {
                return false;
            }
        }

        return true;

    }
}
