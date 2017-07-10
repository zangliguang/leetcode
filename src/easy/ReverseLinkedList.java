package easy;

/**
 * Created by zangliguang on 2017/6/14.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = head.next;
        ListNode n = reverseList(p);

        head.next = null;
        p.next = head;
        return n;
    }


    public ListNode reverseList2(ListNode root) {
        if (root == null || root.next == null) return root;

        ListNode current = root;
        ListNode p = root.next;
        current.next = null;
        ListNode nxt;
        while (p != null) {
            nxt = p.next;
            p.next = current;
            current = p;
            p = nxt;
        }
        return current;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
