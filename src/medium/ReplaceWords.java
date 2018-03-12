package medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * num648
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
 * <p>
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 * <p>
 * You need to output the sentence after the replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * <p>
 * Note:
 * <p>
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 */
public class ReplaceWords {

    public static void main(String[] args) {

    }

    public static String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        StringBuffer sb = new StringBuffer();

        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            String item = split[i];
            for (String dic : dict) {
                if (item.startsWith(dic)) {
                    split[i] = dic;
                    break;
                }
            }
            sb.append(split[i] + " ");
        }
        String s = sb.toString();
        return s.substring(0, s.length() - 1);


    }
}
