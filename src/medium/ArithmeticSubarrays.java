package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1630. Arithmetic Subarrays
 */
public class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean>result=new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i]+1];
            for (int k = l[i]; k <= r[i]; k++) {
                arr[k-l[i]] = nums[k];
            }
            Arrays.sort(arr);
            int d=arr[1]-arr[0];
            boolean value=true;
            for (int j = 2; j < arr.length; j++) {
                if(arr[j]-arr[j-1]!=d){
                    value=false;
                    break;
                }
            }
            result.add(value);

        }
        return result;

    }
}
