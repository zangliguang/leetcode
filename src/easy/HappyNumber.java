package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zangliguang on 2017/6/23.Num202
 */
public class HappyNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " isHappy" + isHappy(i));
        }
    }

    public static boolean isHappy(int n) {
        return getNextNum(n, new HashSet<>()) == 1;
    }

    private static int getNextNum(int n, Set<Integer> set) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        while (n > 0) {
            result += Math.pow((n % 10), 2);
            n /= 10;
        }

        if (result == 1) {
            return 1;
        }
        if (set.contains(result)) {
            return 0;
        }
        set.add(result);
        return getNextNum(result, set);
    }
}
