package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *1394  Find Lucky Integer in an Array
 */
public class FindLuckyIntegerinanArray {

    public int findLucky(int[] arr) {

        int[] mark=new int[500];
        Arrays.fill(mark,0);
        for (int i : arr) {
            mark[i]++;
        }
        for (int i = mark.length - 1; i >= 0; i--) {
            if(mark[i]==i){
                return i;
            }
        }
        return -1;
    }
}
