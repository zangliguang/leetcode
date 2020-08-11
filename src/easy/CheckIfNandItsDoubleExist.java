package easy;

import java.util.HashSet;

/**
 * 1346 Check If N and Its Double Exist
 */
public class CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {

            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            }
            set.add(i);
        }
        return false;

    }
}
