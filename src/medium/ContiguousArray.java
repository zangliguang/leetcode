package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 */
public class ContiguousArray {

    public int findMaxLength2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            else {
                sumToIndex.put(sum, i);
            }
        }

        return max;
    }
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        int zero=0;
        int one=0;
        int len=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }else{
                one++;
            }

            if(map.containsKey(zero-one)){
                len=Math.max(len,i-map.get(zero-one));
            }else{
                map.put(zero-one,i);
            }
        }

        return len;
    }
}
