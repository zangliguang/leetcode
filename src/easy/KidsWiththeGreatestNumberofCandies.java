package easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1431 Kids With the Greatest Number of Candies
 */
public class KidsWiththeGreatestNumberofCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max).collect(Collectors.toList());

    }
}
