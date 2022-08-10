package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1887 Reduction Operations to Make the Array Elements Equal
 */
public class ReductionOperationstoMaketheArrayElementsEqual {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3};
        System.out.println(reductionOperations(nums));
    }

    public static int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int head=nums[0];
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>head){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        int result=0;
        int size=1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result+= entry.getValue()*size;
            size++;
        }
        return result;
    }
}
