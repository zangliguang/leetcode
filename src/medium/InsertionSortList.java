package medium;

/**
 * Created by zangliguang on 2017/6/17.Num141
 */

/**
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n1 = insertionSortList(n1);

        printList(n1);

    }

    public static void printList(ListNode x) {
        if (x != null) {
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }

    }

    public static ListNode insertionSortList(ListNode head) {

        if (null == head || head.next == null)
            return head;

        ListNode newList = new ListNode(head.val);
        ListNode result = new ListNode(-1);
        result.next = newList;
        while (null != head.next) {
            ListNode current = new ListNode(head.next.val);
            newList = result;
            while (null != newList) {

                if (null == newList.next) {
                    newList.next = current;
                    break;
                }
                if (current.val > newList.next.val) {
                    newList = newList.next;
                } else {
                    current.next = newList.next;
                    newList.next = current;
                    break;
                }

            }
            head = head.next;
        }

        return result.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
