package medium;

/**
 * num148
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        sortList(l1);
    }


    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);

        newHead.next = new ListNode(head.val);
        head = head.next;


        while (head != null) {

            ListNode pointer = head.next;
            if (head.val <= newHead.next.val) {
                head.next = newHead.next;
                newHead.next = head;
                head = pointer;
                continue;
            }
            ListNode newPointer = newHead.next;
            while (head.val > newPointer.val) {
                if (newPointer.next != null) {
                    if (head.val <= newPointer.next.val) {
                        head.next = newPointer.next;
                        newPointer.next = head;
                        break;
                    }
                    newPointer = newPointer.next;
                } else {
                    head.next = null;
                    newPointer.next = head;
                    break;

                }

            }
            head = pointer;
        }
        return newHead.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
