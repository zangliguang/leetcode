package medium;

/**
 * 2120. Execution of All Suffix Instructions Staying in a Grid
 */
public class ExecutionofAllSuffixInstructionsStayinginaGrid {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] result = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int y = startPos[0], x = startPos[1], value = 0;

            for (int j = i; j < chars.length; j++) {
                if (chars[j] == 'L' && x > 0) {
                    x--;
                    value++;

                } else if (chars[j] == 'R' && x < n - 1) {
                    x++;
                    value++;

                } else if (chars[j] == 'U' && y > 0) {
                    y--;
                    value++;

                } else if (chars[j] == 'D' && y < n - 1) {
                    y++;
                    value++;
                } else {

                    break;
                }
            }
            result[i] = value;
        }

        return result;
    }
}
