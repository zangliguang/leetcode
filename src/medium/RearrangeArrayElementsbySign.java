package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2149 Rearrange Array Elements by Sign
 */
public class RearrangeArrayElementsbySign {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }

        }

        for (int i = 0; i < list1.size(); i++) {
            nums[2*i] = list1.get(i);
            nums[2*i+1] = list2.get(i);
        }
        return nums;

    }
}
