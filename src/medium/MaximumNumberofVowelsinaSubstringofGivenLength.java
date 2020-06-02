package medium;

/**
 * 1456 Maximum Number of Vowels in a Substring of Given Length
 */
public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(chars[i])) {
                max++;
            }
        }
        if (max == k) {
            return max;
        }
        int preFlag = max, current = max;
        for (int i = 1; i <= chars.length - k; i++) {
            if (isVowel(chars[i - 1])) {
                current--;

            }
            if (isVowel(chars[i - 1 + k])) {
                current++;

            }
            max = Math.max(Math.max(current, preFlag), max);
            if (max == k) {
                return max;
            }
            preFlag = current;
        }
        return max;

    }

    private boolean isVowel(char aChar) {
        return aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u';
    }
}
