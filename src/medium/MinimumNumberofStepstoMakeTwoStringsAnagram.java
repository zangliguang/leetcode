package medium;

/**
 * 1347. Minimum Number of Steps to Make Two Strings Anagram
 */
public class MinimumNumberofStepstoMakeTwoStringsAnagram {
    public static void main(String[] args) {
        System.out.println(minSteps( "bab",  "aba"));
    }
    public static int minSteps(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int[] SA= new int[26];
        int[] ST= new int[26];

        for (int i = 0; i < charS.length; i++) {
            SA[charS[i]-'a']++;
        }for (int i = 0; i < charT.length; i++) {
            ST[charT[i]-'a']++;
        }
        int result =0;
        for (int i = 0; i < 26; i++) {
            result+=Math.abs(SA[i]-ST[i]);
        }
        return result/2;
    }
    public static int minSteps2(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int[] SA= new int[26];

        for (int i = 0; i < charS.length; i++) {
            SA[charS[i]-'a']++;
        }for (int i = 0; i < charT.length; i++) {
            SA[charT[i]-'a']--;
        }
        int result =0;
        for (int i = 0; i < 26; i++) {
            result+=Math.abs(SA[i]);
        }
        return result/2;
    }
}
