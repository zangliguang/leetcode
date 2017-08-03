package easy;

/**
 * Created by zangliguang on 2017/7/31.Num500
 */

import java.util.stream.Stream;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String line1 = "qwertyuiop";
        String line2 = "asdfghjkl";
        String line3 = "zxcvbnm";
        String result = "";
        for (String word : words) {
            if (word.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")) {
                result += word;
                result += ",";
            }
        }
        String[] split = result.split(",");
        if (split.length == 1 && split[0].equals("")) {
            return new String[0];
        }
        return split;

    }

    public String[] findWords2(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}
