package medium;

/**
 * 1004 Max Consecutive Ones III
 */
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] arr=new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(arr,3));
    }
    public static int longestOnes(int[] A, int K) {
        int index=0,start=0,result=0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]==0){
                index++;
            }
            if(index==K+1){
                result=Math.max(result,i-start);
                while(A[start]!=0){
                    start++;
                }
                index--;
                start++;
            }

        }
        return   Math.max(result,A.length-start);

    }
}
