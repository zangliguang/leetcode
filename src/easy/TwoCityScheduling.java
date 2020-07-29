package easy;

import java.util.Arrays;

/**
 * 1029 Two City Scheduling
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int total = 0;
        int[] c2 = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {

            int[] cost = costs[i];
            total += cost[0];
            c2[i] = cost[1] - cost[0];

        }

        Arrays.sort(c2);
        for (int i = 0; i < c2.length / 2; i++) {
            total += c2[i];
        }
        return total;

    }
}

