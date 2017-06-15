package Medium; /**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode tempResult = new ListNode((l1.val + l2.val + flag) % 10);
        ListNode realResult = tempResult;
        flag = (l1.val + l2.val + flag) / 10;
        int tempValue = 0;
        l1 = l1.next;
        l2 = l2.next;
        while (null != l1 || null != l2) {
            tempValue += flag;
            if (null != l1) {
                tempValue += l1.val;
            }
            if (null != l2) {
                tempValue += l2.val;
            }

            tempResult.next = new ListNode((tempValue) % 10);

            flag = (tempValue) / 10;


            tempResult = tempResult.next;
            if (l1 != null) {
                l1 = l1.next;

            }
            if (l2 != null) {
                l2 = l2.next;
            }
            tempValue = 0;
        }
        if (flag > 0) {
            tempResult.next = new ListNode(flag);
        }

        return realResult;

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
