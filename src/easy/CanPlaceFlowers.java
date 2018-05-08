package easy;

/**
 * Created by zangliguang on 2017/6/17.Num605
 */

/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * <p>
 * Note:
 * <p>
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = new int[]{0, 0, 1, 0};
        System.out.println(canPlaceFlowers(flowerbed, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (2 * n - 1 > flowerbed.length) {
            return false;
        }
        int head = -1;
        int tail = flowerbed.length;
        for (int i = 0; i < flowerbed.length; i++) {
            int currenBed = flowerbed[i];
            if (currenBed == 0) {
                if (head < 0) {

                    head = i;
                }
            } else if (head >= 0) {
                tail = i;
                n -= getflowerNum(head, tail, flowerbed.length);
                head = -1;
                tail = flowerbed.length;
                if (n <= 0) {
                    return true;
                }
            }

        }
        if (head >= 0) {
            n -= getflowerNum(head, tail, flowerbed.length);
        }
        return n <= 0;
    }

    private static int getflowerNum(int head, int tail, int totalSize) {

        if (head > 0 && tail <= totalSize - 1) {
            //数组中间
            return (tail - head) / 2 + (tail - head) % 2 - 1;
        }
        if (head == 0 && tail > totalSize - 1) {
            //全部
            return totalSize / 2 + totalSize % 2;
        } else if (head == 0 && tail <= totalSize - 1) {
            //开头
            return tail / 2;

        } else if (head >= 0 && tail > totalSize - 1) {
            //结尾

            return (totalSize - head) / 2;
        }
        return 0;

    }

}



