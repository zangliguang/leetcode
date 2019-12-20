package easy;

/**
 * 686. Repeated String Match
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 * <p>
 * For example, with A = "abcd" and B = "cdabcdab".
 * <p>
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int bLength = B.length();
        int num = 1;
        while (sb.length() < bLength) {
            num++;
            sb.append(A);
        }
        if (sb.toString().contains(B)) {
            return num;
        }
        if (sb.append(A).toString().contains(B)) {
            return num + 1;
        }
        return -1;
    }
}
