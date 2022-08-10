package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1897 Redistribute Characters to Make All Strings Equal
 */
public class RedistributeCharacterstoMakeAllStringsEqual {

    public boolean makeEqual(String[] words) {
        int length = words.length;
        HashMap<Character, Integer> map = new HashMap();
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                map.put(aChar, map.getOrDefault(aChar, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % length != 0)
                return false;
        }
        return true;
    }

    public boolean makeEqual2(String[] words) {
        int length = words.length;
        int[] charArray=new int[26];
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                charArray[aChar-'a']++;
            }
        }
        for (int i : charArray) {

            if(i% length !=0)
                return false;
        }
        return true;
    }

}
