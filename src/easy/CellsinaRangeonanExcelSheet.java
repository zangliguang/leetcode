package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2194. Cells in a Range on an Excel Sheet
 */
public class CellsinaRangeonanExcelSheet {
    public static void main(String[] args) {
        cellsInRange("K1:L2");
    }
    public static List<String> cellsInRange(String s) {
        char[] chars = s.toCharArray();
        int startA = chars[0]-'0' ;
        int startI = chars[1]-'0' ;
        int endA = chars[3]-'0' ;
        int endI = chars[4]-'0' ;

        List<String> result = new ArrayList<>();
        for (int i = startA; i <=endA; i++) {
            for (int j = startI; j <= endI; j++) {
                result.add(String.valueOf( new char[]{(char) (i+'0'), (char) (j+'0')}) );
            }
        }
        return result;

    }
}
