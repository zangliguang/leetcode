package easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * num1005 Maximize Sum Of Array After K Negations
 * Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)
 * <p>
 * Return the largest possible sum of the array after modifying it in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 * Example 2:
 * <p>
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 * Example 3:
 * <p>
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 */
public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {

    }

    public static int largestSumAfterKNegations(int[] A, int K) {

        int result = 0;
        Arrays.sort(A);
        if (A[0] >= 0) {
            for (int i : A) {
                result += i;
            }
            if (K % 2 == 1) {
                result -= A[0] * 2;
            }
            return result;
        }

        int negative = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0&&negative<K) {
                A[i]*=-1;
                negative++;
            }else{
                break;
            }
        }
        if(K-negative==0){

            for (int i : A) {
                result += i;
            }
            return  result;
        }else{
            return largestSumAfterKNegations(A,K-negative);
        }


    }

    public int largestSumAfterKNegations2(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int x: A) pq.add(x);
        while( K--  > 0) pq.add(-pq.poll());

        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += pq.poll();
        }
        return sum;
    }
}
