package easy;

/**
 * Created by zangliguang on 2017/7/4. Num21
 */

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode resultHead = head;


        while (null != l1 || null != l2) {
            if (l2 == null) {
                head.next = l1;
                break;
            }
            if (l1 == null) {
                head.next = l2;
                break;
            }

            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;

        }
        return resultHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
