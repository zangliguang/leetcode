package easy;

import java.util.*;

public class TooEasy {


    /**
     * 2160. Minimum Sum of Four Digit Number After Splitting Digits
     */
    public static int minimumSum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);

        int num1 = 0, num2 = 0;
        for (int i = 0; i <= chars.length - 1; i += 2) {
            num1 = num1 * 10 + chars[i] - '0';
            if (i + 1 < chars.length) {
                num2 = num2 * 10 + chars[i + 1] - '0';
            }

        }
        return num1 + num2;
    }


    /**
     * 1603. Design Parking System
     */
    class ParkingSystem {
        int big;
        int medium;
        int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1 && big > 0) {
                big -= 1;
                return true;
            }
            if (carType == 2 && medium > 0) {
                medium -= 1;
                return true;
            }
            if (carType == 3 && small > 0) {
                small -= 1;
                return true;
            }
            return false;

        }
    }

    /**
     * 1678. Goal Parser Interpretation
     */
    public String interpret(String command) {

        command = command.replace("(al)", "al");
        command = command.replace("()", "o");
        return command;
    }

    /**
     * 2114. Maximum Number of Words Found in Sentences
     *
     * @param sentences
     * @return
     */
    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (String sentence : sentences) {
            max = Math.max(sentence.split(" ").length, max);
        }
        return max;

    }

    /**
     * 2047. Number of Valid Words in a Sentence
     */
    public int countValidWords(String sentence) {
        String words[] = sentence.trim().split("\\s+"), regex = "([a-z]+(-?[a-z]+)?)?[!\\.,]?";
        return (int) Arrays.stream(words).filter(w -> w.matches(regex)).count();

    }

    /**
     * 1805. Number of Different Integers in a String
     */
    public static int numDifferentIntegers(String word) {
        HashSet<String> set = new HashSet<>();
        char[] chars = word.toCharArray();
        long num = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                if (num != -1) {
                    set.add(String.valueOf(num));
                }

                num = -1;
            } else {

                if (num < 0) {
                    num = 0;
                }
                num = num * 10 + chars[i] - '0';

            }
        }
        if (num != -1) {
            set.add(String.valueOf(num));
        }
        return set.size();

    }

    /**
     * 1037. Valid Boomerang
     *
     * @param points
     */
    public boolean isBoomerang(int[][] points) {
        boolean b1 = points[0][0] != points[1][0] || points[0][1] != points[1][1];
        boolean b2 = points[1][1] != points[2][1] || points[1][0] != points[2][0];
        boolean b3 = points[0][1] != points[2][1] || points[0][0] != points[2][0];
        if (b1 && b2 && b3) {
            if (points[1][0] - points[0][0] == 0 || points[2][0] - points[0][0] == 0) {
                return true;
            }

            return ((points[1][1] - points[0][1]) * 1.0) / (points[1][0] - points[0][0]) != ((points[2][1] - points[0][1]) * 1.0) / (points[2][0] - points[0][0]);

        }
        return false;

    }

    /**
     * 1800. Maximum Ascending Subarray Sum
     *
     * @param nums
     */
    public int maxAscendingSum(int[] nums) {

        return 0;
    }


    /**
     * 1668. Maximum Repeating Substring
     *
     * @param sequence
     * @param word
     * @return
     */
    public static int maxRepeating(String sequence, String word) {

        String find = "";
        while (sequence.contains(find)) find += word;
        return (find.length() - word.length()) / word.length();
    }


    /**
     * 2325. Decode the Message
     *
     * @param key
     * @param message
     * @return
     */
    public static String decodeMessage(String key, String message) {
        HashMap<Character, Integer> map = new HashMap<>();

        key = key.replace(" ", "");
        char[] chars = key.toCharArray();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], index);
                index++;
            }

        }
        char[] mChars = message.toCharArray();
        for (int i = 0; i < mChars.length; i++) {

            if (mChars[i] != ' ') {
                mChars[i] = (char) ('a' + map.get(mChars[i]));
            }

        }
        return String.valueOf(mChars);

    }

    /**
     * 2367. Number of Arithmetic Triplets
     *
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] + diff) && set.contains(nums[i] + 2 * diff)) {
                result++;
            }
        }

        return result;

    }

    /**
     * 2006. Count Number of Pairs With Absolute Difference K
     *
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + k)) {
                result += entry.getValue() * map.get(entry.getKey() + k);
            }
        }
        return result;

    }

    /**
     * 1773. Count Items Matching a Rule
     *
     * @param items
     * @param ruleKey
     * @param ruleValue
     * @return
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int index = 2;
        if (ruleKey.equals("type")) {
            index = 0;
        } else if (ruleKey.equals("color")) {
            index = 1;
        }

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(index).equals(ruleValue)) res++;
        }

        return res;

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 2331. Evaluate Boolean Binary Tree
     *
     * @param root
     * @return
     */
    public boolean evaluateTree(TreeNode root) {
        boolean result = false;
        if (root.left==null&&root.right==null){
            return root.val==1;
        }
        if(root.val==2){
            return evaluateTree(root.left)||evaluateTree(root.right);
        }else{
            return evaluateTree(root.left)&&evaluateTree(root.right);
        }

    }

    public static void main(String[] args) {

        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv"));
    }
}
