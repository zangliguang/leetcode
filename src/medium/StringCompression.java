package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * String Compression
 * 443. String Compression
 */
public class StringCompression {


    public static void main(String[] args) {
       char[] cs={'a','b','b','b','b','b','b','b','b','b','b','b','b'} ;
        System.out.println(compress(cs));
    }
    public static int compress(char[] chars) {


        List<Character> list=new ArrayList<>();
        if(chars.length<=1){
            return chars.length;
        }

        char f=chars[0];
        list.add(f);
        int nums=1;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]==f){
                nums++;
            }else{
                f=chars[i];

                if(nums>1){
                    String s = String.valueOf(nums);
                    for (char c : s.toCharArray()) {
                        list.add(c);
                    }
                }
                list.add(f);

                nums=1;
            }

        }
        if(nums>1){
            String s = String.valueOf(nums);
            for (char c : s.toCharArray()) {
                list.add(c);
            }
        }
        chars=new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            chars[i]=list.get(i);
        }

        System.out.println(Arrays.toString(chars));

        return list.size();


    }
}
