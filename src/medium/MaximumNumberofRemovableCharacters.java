package medium;

import java.util.*;

/**
 * 1898  Maximum Number of Removable Characters
 */
public class MaximumNumberofRemovableCharacters {
    public static void main(String[] args) {

        System.out.println(maximumRemovals("rqmvwezfxczzeqokjww", "rezxczzeqw", new int[]{1,18,3,7,4,16,14,2,15,0,6,12,17,11,13,5,9}));
    }

    public static int maximumRemovals(String s, String p, int[] removable) {
        int result = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < removable.length; i++) {

            sb.replace(removable[i],removable[i]+1,"#");
            if (!isSonOfS(sb.toString(), p)) {
                return result;
            }
            result++;
        }


        return result;
    }

    private static boolean isSonOfS(String sb, String p) {
        sb=sb.replace("#","");
        int first = sb.indexOf(p.charAt(0));
        if (first < 0) {
            return false;
        }
        for (int j = 1; j < p.length(); j++) {
            int second = sb.indexOf(p.charAt(j),first+1);
            if (second <= first) {
                return false;
            }
            first = second;


        }
        return true;

    }


}
