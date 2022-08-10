package medium;

/**
 * 45. Jump Game II
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 */
public class JumpGameII {
    public static void main(String[] args) {
        int[] arr={5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};

        int result = jump(arr,30,1);
        System.out.println("result:"+result);
    }
    public static int jump(int[] nums, int index, int preResult) {
//        System.out.println("跳了"+preResult+"步，"+(index+1)+"位置"+"，下一步"+nums[index]);
        if(index>=nums.length-1){
            System.out.println("最后跳了"+preResult+"步");
            return preResult;
        }
        if(index==7){
//            System.out.println("最后跳了步");
        }
        if(index+nums[index]>=nums.length-1){
            System.out.println("最后跳了"+(preResult+1)+"步");
            return  preResult+1;
        } else{
            if(nums[index]==1){
                return jump(nums,1+index,preResult+1);
            }
            int result=Integer.MAX_VALUE;

            for (int i = 1; i < nums[index]; i++) {
                int jump1 = jump(nums, i + index, preResult + 1);
                int jump2 = jump(nums, i + 1 + index, preResult + 1);
                result=Math.min(Math.min(jump1, jump2),result);
                System.out.println("=====跳了第"+(i+index)+"步："+jump1+":"+jump2+"  result:"+result);
//                System.out.println("=====跳了第"+i+"步,result:"+result);
            }
            return result;
        }

    }
    public static int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;

    }
}
