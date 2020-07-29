package easy;

/**
 * 1332 Remove Palindromic Subsequences
 */
public class RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        return s.isEmpty() ? 0 : (s.equals(new StringBuilder(s).reverse().toString()) ? 1:2);
    }
}
