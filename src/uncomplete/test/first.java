package uncomplete.test;

import java.util.Arrays;

public class first {

    public static void main(String[] args) {
//        binaryToDecimal(1000000000);
//        System.out.println(solution(2457));
//        System.out.println(solution(22197));
        System.out.println(solution(255));
//        System.out.println(solution(955));
    }
    static int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        System.out.println(Arrays.toString(d));
        System.out.println(l);
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok&&p<=l/2) {
                return p;
            }
        }
        return -1;
    }


    public static void binaryToDecimal(int n){
        int t = 0;  //用来记录位数
        int bin = 0; //用来记录最后的二进制数
        int r = 0;  //用来存储余数
        while(n != 0){
            r = n % 2;
            n = n / 2;
            bin += r * Math.pow(10,t);
            t++;
        }
        System.out.println(bin);
    }
}
