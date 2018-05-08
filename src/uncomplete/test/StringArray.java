package uncomplete.test;

import java.util.Arrays;

public class StringArray {
    public static void main(String[] args) {
        String[] strs = new String[]{"sad", "sad", "asd"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i] + "-");
        }
        System.out.println(sb);
        String[] split = sb.toString().split("-");
        System.out.println(Arrays.toString(split));
    }
}
