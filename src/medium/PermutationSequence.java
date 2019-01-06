package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * num60
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        LinkedList<Integer> notUsed = new LinkedList<Integer>();

        int weight = 1;

        for (int i = 1; i <= n; i++) {
            notUsed.add(i);
            if (i == n)
                break;
            weight = weight * i;
        }

        String res = "";
        k = k - 1;
        while (true) {
            res = res + notUsed.remove(k / weight);
            k = k % weight;
            if (notUsed.isEmpty())
                break;
            weight = weight / notUsed.size();
        }

        return res;


    }
}
