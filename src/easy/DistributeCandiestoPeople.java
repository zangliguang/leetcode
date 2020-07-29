package easy;

import java.util.Arrays;

/**
 * 1103 Distribute Candies to People
 */
public class DistributeCandiestoPeople {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(10,3)));
    }
    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int i = 1;
        while (candies > i) {
            result[(i-1)%(num_people)] += i;
            candies-=i;
            i++;

        }
        if(candies>0){
            result[(i-1)%(num_people)] += candies;
        }

        return result;
    }
}
