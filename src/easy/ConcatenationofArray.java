package easy;

import java.util.Arrays;

/**
 * 1929. Concatenation of Array
 * 1920. Build Array from Permutation
 */
public class ConcatenationofArray {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length;
        int[] result=new int[size *2];
        for (int i = 0; i < size; i++) {
            result[i]=nums[i];
            result[i+size]=nums[i];
        }
                return result;


    }


    public int[] buildArray(int[] nums) {
        int size = nums.length;
        int[] result=new int[size];
        for (int i = 0; i < size; i++) {
            result[i]=nums[nums[i]];

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={105,924,32,968};
        System.out.println(canBeIncreasing(nums));
    }
    public static boolean canBeIncreasing(int[] nums) {
        int count=0;
        int p=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1] || nums[i]==nums[i+1]) {
                count++;
                p=i;
            }
        }
        if(count>1) return false;
        else if(count==1){
            if(p==0 || p== nums.length-2) return true;
            if(nums[p+1]>nums[p-1] || nums[p+2]>nums[p]) return true;
            else return false;
        }
        return true;
    }
}
