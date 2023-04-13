package medium;

/**
 * 2246 Apply Bitwise Operations to Make Strings Equal
 */
public class ApplyBitwiseOperationstoMakeStringsEqual {
    public static void main(String[] args) {
        System.out.println(makeStringsEqual("101110100","110011000"));
    }
    public static boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1");

    }
}
