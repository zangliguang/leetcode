package easy;

import java.util.ArrayList;

/**
 * 696 Count Binary Substrings
 */
public class CountBinarySubstrings {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110"));
    }
    public static  int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(chars[0], 1));
        for (int i = 1; i < chars.length; i++) {
            Node last = list.get(list.size() - 1);
            if (chars[i] == last.value) {
                list.set(list.size() - 1,last).num++;
            } else {
                list.add(new Node(chars[i], 1));
            }
        }
        int result = 0;
        for (int i = 1; i < list.size(); i++) {
            int max = Math.min(list.get(i - 1).num, list.get(i).num);
            result += max;
        }
        return result;

    }

    static class Node {
        int value;
        int num;

        public Node(int value, int num) {
            this.value = value;
            this.num = num;
        }
    }
}
