package medium;

import easy.ReverseLinkedList;

/**
 * 92. Reverse Linked List II
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * Accepted
 * 171,601
 * Submissions
 * 511,401
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        reverseBetween(l1, 3, 4);

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode origin = head;
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode first = head, firstPre = null;
        ListNode last, lastLater;
        for (int i = 1; i < n; i++) {
            if (i == m - 1) {
                firstPre = head;
                first = head.next;
            }
            head = head.next;
        }
        last = head;
        lastLater = last.next;

        last.next = null;
        ListNode newFirst = reverseList(first);
        ListNode newTail = null;
        if (null != firstPre) {
            firstPre.next = newFirst;
        }
        newTail = newFirst.next;

        while (newTail.next != null) {
            newTail = newTail.next;
        }

        newTail.next = lastLater;
        return m == 1 ? newFirst : origin;

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
