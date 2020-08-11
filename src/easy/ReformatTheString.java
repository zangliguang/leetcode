package easy;

import java.util.ArrayList;

/**
 * 1417 Reformat The String
 */
public class ReformatTheString {
    public String reformat(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Integer> digit = new ArrayList<>();
        ArrayList<Integer> alpha = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                digit.add(i);
            } else {
                alpha.add(i);
            }
        }
        if (Math.abs(alpha.size() - digit.size()) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(alpha.size(), digit.size()); i++) {
            sb.append(chars[alpha.get(i)]);
            sb.append(chars[digit.get(i)]);
        }
        if (alpha.size() > digit.size()) {
            sb.append(chars[alpha.get(alpha.size() - 1)]);
        } else if (alpha.size() < digit.size()) {
            sb.insert(0, chars[digit.get(digit.size() - 1)]);
        }
        return sb.toString();
    }
}
