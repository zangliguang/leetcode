package easy;

import java.util.Arrays;
import java.util.Collections;

/**
 * 1128 Number of Equivalent Domino Pairs
 */
public class NumberofEquivalentDominoPairs {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{2, 1};
        int[] f = new int[]{1, 2};
        int[] c = new int[]{3, 2};
        int[] d = new int[]{4, 2};
        int[][] e = new int[][]{a, b, c, d, f};
        System.out.println(numEquivDominoPairs(e));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int result = 0, num;
        int[] mark = new int[dominoes.length];
        for (int i = 0; i < dominoes.length; i++) {
            if (mark[i] == 1) {
                continue;
            }
            mark[i] = 1;
            num = 1;
            for (int j = i + 1; j < dominoes.length; j++) {
                if (mark[j] == 1) {
                    continue;
                }
                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) {
                    mark[j] = 1;
                    num++;
                } else if (dominoes[i][1] == dominoes[j][0] && dominoes[i][0] == dominoes[j][1]) {
                    mark[j] = 1;
                    num++;
                }
            }
            if (num > 1) {
                result += (num * (num - 1)) / 2;
            }
        }
        return result;

    }
}
