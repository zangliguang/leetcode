package uncomplete.test;


import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by zangliguang on 2017/7/6.
 */
public class Test {
    public static void main(String[] args) {
//        File directory = new File("");//参数为空
//        String courseFile = null;
//        try {
//            courseFile = directory.getCanonicalPath();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(courseFile);
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println( System.getProperty("java.class.path"));
//        System.out.println( System.getProperty("java.class.path"));
        String[] vids=new String[]{"179094","238753","249813"};
        for (int i = 0; i < vids.length; i++) {
            String ts = String.valueOf(System.currentTimeMillis() / 1000);
            String vid = vids[i];
            String url=String.format("http://api.rekonquer.com/psvs/mp4.php?vid=%s&ts=%s&sign=%s", vid, ts, b(vid, ts));
            System.out.println(url);
        }
//        String ts = String.valueOf(System.currentTimeMillis() / 1000);
//        String vid = "152915";
//        String url=String.format("http://api.rekonquer.com/psvs/mp4.php?vid=%s&ts=%s&sign=%s", vid, ts, b(vid, ts));
//        System.out.println(url);
    }


    public static String b(String s1, String s2) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            System.out.println("第一次修正："+ String.format("%s%sBrynhildr", s1, s2));
            byte[] bytes = md.digest(String.format("%s%sBrynhildr", s1, s2).getBytes());
            System.out.println("MD5加密："+ Arrays.toString(bytes));
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String bytesToHex(byte[] bytes) {
        final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        System.out.println("最终结果："+new String(hexChars));
        return new String(hexChars);
    }

    private void printPath() {
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
    }


    public static int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    // It's easy to handle edge cases when
// operate with long numbers rather than int
    public static long divideLong(long dividend, long divisor) {

        // Remember the sign
        boolean negative = dividend < 0 != divisor < 0;

        // Make dividend and divisor unsign
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;

        // Return if nothing to divide
        if (dividend < divisor) return 0;

        // Sum divisor 2, 4, 8, 16, 32 .... times
        long sum = divisor;
        long divide = 1;
        while ((sum+sum) <= dividend) {
            sum += sum;
            System.out.println("sum："+sum);
            divide += divide;
        }

        System.out.println(divide);
        // Make a recursive call for (devided-sum) and add it to the result
        return negative ? -(divide + divideLong((dividend-sum), divisor)) :
                (divide + divideLong((dividend-sum), divisor));
    }
}
