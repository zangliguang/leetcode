package easy;

/**
 * Created by zangliguang on 2017/6/14.Num206
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        ListNode p = head.next;
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

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextTemp;
        while (curr != null) {
            nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
