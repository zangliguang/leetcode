package uncomplete.test;

import java.util.Arrays;

public class StringArray {
    public static void main(String[] args) {
//        String[] strs = new String[]{"sad", "sad", "asd"};
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < strs.length; i++) {
//            sb.append(strs[i] + "-");
//        }
//        System.out.println(sb);
//        String[] split = sb.toString().split("-");
//        System.out.println(Arrays.toString(split));

        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
    }

    public  static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length = v2.length;
        boolean v1isLonger = true;
        if (v1.length < v2.length) {
            length = v1.length;
            v1isLonger = false;
        }

        for (int i = 0; i < length; i++) {
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                return 1;
            }
            if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                return -1;
            }
        }

        if (v1.length == v2.length) {
            return 0;
        }
        if (v1isLonger) {
            for (int i = v2.length; i < v1.length; i++) {
                if (Integer.parseInt(v1[i]) > 0) {
                    return 1;
                }
            }

        } else {
            for (int i = v1.length; i < v2.length; i++) {
                if (Integer.parseInt(v2[i]) > 0) {
                    return -1;
                }
            }
        }
        return 0;


    }
}
