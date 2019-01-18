package medium;

/**
 * 143. Reorder List
 * <p>
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
//        ReverseLinkedListII.ListNode l5 = new ReverseLinkedListII.ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;

        reorderList(l1);
    }


    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p2 = reverseList(p1.next);
        p1.next=null;
        p1 = head;
        ListNode temp = null;
        while (p1 != null && p2 != null) {
            temp = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1.next.next = temp;

            p1 = temp;
        }
        System.out.println(head.val);

    }

    private static  ListNode reverseList(ListNode head) {
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
