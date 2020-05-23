package medium;

/**
 * 394. Decode String
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println( decodeString("100[leetcode]"));
    }
    public static String decodeString(String s) {
        int firstIndex = s.lastIndexOf('[');
        int num = 0;
        int endIndex = 0;
        for (int i = firstIndex+1; i < s.length(); i++) {
            if(s.charAt(i)==']'){
                for (int j = firstIndex-1; j >=0 ; j--) {
                    if(!Character.isDigit(s.charAt(j))){
                        num= Integer.parseInt(s.substring(j+1,firstIndex));
                        endIndex=j+1;
                        break;
                    }
                    if(j==0){
                        num= Integer.parseInt(s.substring(0,firstIndex));
                    }
                }
                String str = s.substring(firstIndex+1,i);
                StringBuilder sb=new StringBuilder();
                for (int j = 0; j < num; j++) {
                    sb.append(str);
                }
                return decodeString(s.substring(0,endIndex)+sb.toString()+s.substring(i+1));

            }

        }
        return s;
    }
}
