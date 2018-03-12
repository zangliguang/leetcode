package medium;

import java.util.Stack;

/**
 * Created by zangliguang on 2017/7/13. Num445
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val = head.val;
            if (!stack1.isEmpty()) {
                val += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val += stack2.pop();
            }
            ListNode node = new ListNode(val % 10);
            node.next = head.next;
            head.val = val / 10;
            head.next = node;

        }
        return head.val == 0 ? head.next : head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
