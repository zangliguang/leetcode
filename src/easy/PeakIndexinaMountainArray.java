package easy;

/**
 * 852. Peak Index in a Mountain Array
 * Let's call an array A a mountain if the following properties hold:
 * <p>
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 */
public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray2(int[] A) {
        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) { return i; }
        }
        return -1;
    }
    public int peakIndexInMountainArray(int[] A) {
        int head=0;
        int tail=A.length-1;
        while(head<tail){
            int mid=(head+tail)>>>1;
            if(A[mid]<A[mid+1]){
                head=mid;
            }else if(A[mid]<A[mid-1]){
                tail=mid;
            }else{
                return mid;
            }

        }
        return -1;
    }
}
