package medium;

import java.util.Arrays;

/**
 * 128. Longest Consecutive Sequence
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums={ 1,2,0,1};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        Arrays.sort(nums);
        int result=1;
        int temp=1;
        for (int i = 0; i < nums.length-1; i++) {

            if(nums[i+1]-1==nums[i]){
                temp++;
                result=Math.max(result,temp);
            }else if(nums[i+1]!=nums[i]){
                temp=1;
            }
        }
        return result;
    }
}
