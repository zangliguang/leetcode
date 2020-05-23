package easy;

import java.util.LinkedHashSet;

/**
 * 1337 The K Weakest Rows in a Matrix
 */
public class TheKWeakestRowsinaMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] arr = new int[k];
        int r = mat.length;
        int c = mat[0].length;
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (mat[j][i] == 0 && !set.contains(j)) {
                    set.add(j);
                    if (set.size() == k) {
                        return getInts(arr, set);
                    }
                }
            }
        }
        while(set.size()<k){
            for (int j = 0; j < r; j++) {
                if(mat[j][c-1]==1){
                    set.add(j);
                    if(set.size()==k){
                        return getInts(arr, set);
                    }
                }
            }
        }

        return arr;
    }

    private int[] getInts(int[] arr, LinkedHashSet<Integer> set) {
        Object[]ints =  set.toArray();
        for (int l = 0; l < ints.length; l++) {
            arr[l]=(Integer) ints[l];
        }
        return arr;
    }
}
