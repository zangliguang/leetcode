package medium;

import java.util.*;

public class TooEasy {

    /**
     * 2181. Merge Nodes in Between Zeros
     */
    public ListNode mergeNodes(ListNode head) {

        if(head==null||head.next==null){
            return head;
        }
        ListNode tempResult=head;

        while (head!=null){
            if(head.val!=0&&head.next!=null&&head.next.val!=0){
                head.val+=head.next.val;
                head.next=head.next.next;
            }else{
                head=head.next;
            }
        }
        while (tempResult.val==0){
            tempResult=tempResult.next;
        }
        ListNode finalResult=tempResult;
        while (tempResult!=null){
            if(null!=tempResult.next&&tempResult.next.val==0){
                tempResult.next=tempResult.next.next;
            }else{
                tempResult=tempResult.next;
            }
        }
       return finalResult;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 1828. Queries on Number of Points Inside a Circle
     * @param points
     * @param queries
     * @return
     */
    public int[] countPoints(int[][] points, int[][] queries) {
        int[]result=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int num=0;
            for (int[] point : points) {

                if( Math.pow(queries[i][0]-point[0],2)+Math.pow(queries[i][1]-point[1],2)<Math.pow(queries[i][2],2)){
                    num++;
                }
            }
            result[i]=num;
        }
        return result;

    }


    /**
     * 2265. Count Nodes Equal to Average of Subtree
     * @param root
     * @return
     */
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        solve(root, 0);
        return ans


    }
    int ans = 0;

    private int[] solve(TreeNode root, int count) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int left[] = solve(root.left, count);
        int right[] = solve(root.right, count);
        int temp = root.val;
        root.val += (left[0] + right[0]);
        count = (left[1] + right[1]) + 1;
        if (temp == (root.val / count))  ans++;
        return new int[] { root.val, count };
    }


    /**
     * 1769. Minimum Number of Operations to Move All Balls to Each Box
     * @param boxes
     * @return
     */
    public int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='1'){
                list.add(i);
            }
        }
        int[] result=new int[chars.length];
        int num;
        for (int i = 0; i < chars.length; i++) {
             num=0;
            for (Integer integer : list) {
                if(integer!=i){
                    num+=Math.abs(integer-i);
                }
            }
            result[i]=num;
        }
        return result;

    }


    /**
     * 1637. Widest Vertical Area Between Two Points Containing No Points
     * @param points
     * @return
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < points.length-1; i++) {
            max=Math.max(max,points[i+1][0]-points[i][0]);
        }
        return max;

    }

    /**
     * 2130. Maximum Twin Sum of a Linked List
     * @param head
     * @return
     */
    public int pairSum(ListNode head) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int index=0;
        while(head!=null){
            map.put(index,head.val);
            head=head.next;
            index++;
        }
        int max=0;
        for (int i = 0; i < index / 2; i++) {

            max=Math.max(max,map.get(i)+map.get(index-i));
        }
        return max;

    }




}
