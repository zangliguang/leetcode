package easy;

/**
 * 2544 Alternating Digit Sum
 */
public class AlternatingDigitSum {
    public static void main(String[] args) {

        System.out.println(alternateDigitSum(886996));
    }
    public static int alternateDigitSum(int n) {

        int result=0;
        int nums=String.valueOf(n).length();
        while(n>0){
            result+=n%10*(nums%2==0?-1:1);
            n=n/10;
            nums--;
        }
        return result;
    }
}
