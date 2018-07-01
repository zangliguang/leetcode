package hard;

/**
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesinkGroup {
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
        ListNode x = reverseKGroup(l1, 3);
        while (x != null) {

            System.out.println(x.val);
            x = x.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head != null) {

            ListNode prev = null, next = null;
            ListNode root = head;
            int count = 0;

            while (root != null && count < k) {
                next = root.next;
                prev = root;
                root = root.next;
                count++;
            }

            //For the left-out nodes to remain as it is.
            if (count < k)
                return head;

            prev.next = null; //Make this sub-part a linked list on its own (with null at end).
            //Prev is the tail of this sub-part, which will later become the head after reversing the linked list.
            //Prev will thus be used to return at the end.

            ListNode tail = reverse(head);
            tail.next = reverseKGroup(next, k);

            return prev;
        } else
            return head;
    }

    public static ListNode reverse(ListNode head) { //Important thing is that this returns tail, not the head.

        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
