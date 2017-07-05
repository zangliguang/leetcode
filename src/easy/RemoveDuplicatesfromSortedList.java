package easy;

/**
 * Created by zangliguang on 2017/7/4.Num83
 */

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head;
        while (null != head && null != head.next) {
            if (head.val == head.next.val) {
                ListNode temp = head.next.next;
                while (temp != null && temp.val == head.val) {
                    temp = temp.next;
                }

                head.next = temp;
            }


            head = head.next;
        }
        return result;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
