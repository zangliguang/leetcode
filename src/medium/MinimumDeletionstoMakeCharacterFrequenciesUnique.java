package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 */
public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        String aa="ceabaacb";
        System.out.println(minDeletions(aa));
    }
    public static int minDeletions(String s) {

        int[] cnums=new int[26];
        for (char c : s.toCharArray()) {
            cnums[c-'a']++;
        }
        Arrays.sort(cnums);
        int reusult=0;
        int i = 1;

        while (i < cnums.length) {


            if(cnums[i-1]!=0&&cnums[i-1]==cnums[i]){
                cnums[i-1]--;
                reusult++;
                if(cnums[i-1]!=0&&i>1&&cnums[i-1]==cnums[i-2]){
                    i--;
                    continue;
                }
            }
            i++;
        }
        return reusult;

    }
}
