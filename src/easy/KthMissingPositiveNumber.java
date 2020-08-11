package easy;

/**
 * 1539 Kth Missing Positive Number
 */
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr =new int[] {1,2,3,4};
        int k=724;
        System.out.println(findKthPositive(arr,k));
    }
    public static int findKthPositive(int[] arr, int k) {
        int[] temp=new int[2001];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]=arr[i];
        }
        int result=0;
        for (int i = 1; i < temp.length; i++) {
            if(temp[i]==0){
                result++;
                if(result==k){
                    return i;
                }
            }
        }
        return result;

    }
}
