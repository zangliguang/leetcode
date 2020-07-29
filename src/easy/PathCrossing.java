package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 1496 Path Crossing
 */
public class PathCrossing {
    public static void main(String[] args) {
        int[] a = {0, 1};
        int[] b = {0, 1};
        HashSet<int[]> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(set.size());
        System.out.println(Arrays.equals(a, b));
    }

    public static boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        HashSet<String> set = new HashSet<>();
        String nl = x + "" + y;
        set.add(nl);
        char[] chars = path.toCharArray();
        for (char c : chars) {
            if (c == 'N') {
                y++;

            }
            if (c == 'S') {
                y--;

            }
            if (c == 'E') {
                x++;

            }
            if (c == 'W') {
                x--;

            }

            if (set.contains(nl)) {
                return false;
            }
            set.add(nl);
        }
        return true;

    }
}
