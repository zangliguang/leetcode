package easy;

/**
 * 868 Binary Gap
 */
public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(5));
        System.out.println(binaryGap(6));
        System.out.println(binaryGap(8));
    }
    public static int binaryGap(int N) {
        String s = Integer.toBinaryString(N);
        char[] chars = s.toCharArray();
        int result = 0;
        int start = s.indexOf('1');
        int end = s.lastIndexOf('1');
        for (int i = start + 1; i <= end; i++) {
            if (chars[i] == '1') {
                result = Math.max(result, i - start);
                start = i;
            }
        }
        return result;
    }
}
