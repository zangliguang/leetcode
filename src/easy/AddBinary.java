package easy;

/**
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));
    }

    public static String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            return addBinary(b, a);
        }
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();

        int bl = bc.length;
        int al = ac.length;

        for (int j = bl - 1; j >= 0; j--) {
            if (bc[j] == '0') {
                continue;
            }
            for (int i = ac.length - (bl - j); i >= 0; i--) {

                if (ac[i] == '0') {
                    ac[i] = '1';
                    break;
                } else {
                    ac[i] = '0';
                }
            }
            if (ac[0] == '0') {
                ac = ("1" + new String(ac)).toCharArray();
            }

        }
        return new String(ac);
    }
}
