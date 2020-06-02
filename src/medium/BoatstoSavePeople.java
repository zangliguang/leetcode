package medium;

import java.util.Arrays;

/**
 * 881. Boats to Save People
 */
public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        for (int hi = people.length - 1, lo = 0; hi >= lo; --hi, ++ans) { // high end always moves
            if (people[lo] + people[hi] <= limit) {
                ++lo;
            } // low end moves only if it can fit in a boat with high end.
        }
        return ans;
    }
}
