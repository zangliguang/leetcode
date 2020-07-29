package easy;

/**
 * 1528 Shuffle String
 */
public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] newChars=new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            newChars[indices[i]]=chars[i];
        }
       return new String(newChars);
    }
}
