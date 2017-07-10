package easy;

/**
 * Created by zangliguang on 2017/7/10.Num70
 */

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 */
public class climbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs2(44));
    }

    //速度太慢
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1, b = 2;
        for (int i = 2; i < n; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }
}
