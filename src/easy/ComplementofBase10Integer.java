package easy;

/**
 * 1009 Complement of Base 10 Integer
 */
public class ComplementofBase10Integer {
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(2));
    }

    public static int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return 0;
        }
        int start = 1;
        while (start <= N) {
            start <<= 1;
        }
        start -= 1;
        return start ^ N;

    }
}
