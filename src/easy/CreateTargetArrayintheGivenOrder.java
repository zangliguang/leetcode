package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1389. Create Target Array in the Given Order
 */
public class CreateTargetArrayintheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> lst = new ArrayList<>(); // use list to add elements at index
        for (int i = 0; i < index.length; i++) lst.add(index[i], nums[i]);

        int[] res = new int[nums.length]; // convert list to array
        for (int i = 0; i < index.length; i++) res[i] = lst.get(i);
        return res;
    }

}
