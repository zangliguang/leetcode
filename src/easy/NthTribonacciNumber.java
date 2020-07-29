package easy;

/**
 * 1137 N-th Tribonacci Number
 */
public class NthTribonacciNumber {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        for (int i = 3; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
        return array[n];
    }
}
