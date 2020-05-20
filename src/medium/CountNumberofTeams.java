package medium;

public class CountNumberofTeams {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 9, 5, 10, 8, 2, 1, 6};
        numTeams(arr);
    }

    public static int numTeams(int[] rating) {
        int result = 0, left, left2, right, right2;
        for (int i = 1; i < rating.length - 1; i++) {
            int temp = rating[i];
            left = 0;
            left2 = 0;
            right = 0;
            right2 = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < temp) {
                    left++;
                } else {
                    left2++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > temp) {
                    right++;
                } else {
                    right2++;
                }
            }
            result += left * right;
            result += left2 * right2;

        }
        return result;

    }
}
