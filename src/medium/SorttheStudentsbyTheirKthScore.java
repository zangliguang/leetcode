package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2545 Sort the Students by Their Kth Score
 */
public class SorttheStudentsbyTheirKthScore {

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> Integer.compare(o2[k],o1[k]));
        return  score;


    }
}
