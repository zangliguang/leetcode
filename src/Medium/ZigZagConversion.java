package Medium;

/**
 * num6
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public static void main(String[] args) {

       String str="PAYPALISHIRING";
        System.out.println(convert(str,3));
    }

    public static String convert(String s, int numRows) {
        if(s.length()==0||numRows<2){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int total = chars.length;
        int culumSize = 2 * numRows - 2;
        final int culumn = chars.length / culumSize + ((chars.length % culumSize == 0) ? 0 : 1);
        for (int row = 0; row < numRows; row++) {
            for (int j = 0; j < culumn; j++) {
                int start = j * culumSize + row;
                if(start>=total){
                    break;
                }
                sb.append(chars[start]);
                if(row==0||row==numRows-1){
                    continue;
                }
                int end = j * culumSize + culumSize - row;
                if(end>=total){
                    break;
                }
                sb.append(chars[end]);
                System.out.println(start+"-"+end);

            }
        }

        return sb.toString();
    }
}
