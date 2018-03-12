package medium;

/**
 * num61
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Given 1->2->3->4->5->NULL and k = 2,
 * <p>
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        void print() {
            System.out.print(val + "->");
            if (null != next) {
                next.print();
            }
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        l1.print();
        System.out.println();
        System.out.println("输出结果");
        ListNode result = (rotateRight(l1, 4));
        result.print();


    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode end = head;
        ListNode h2 = head;
        int length = 1;
        while (end.next != null) {
            end = end.next;
            length++;
            if (length > k + 1) {
                h2 = h2.next;
            }
        }
        if (k % length == 0) {
            return head;
        }
        if (k > length) {
            k = k % length;
            int goal = length - k - 1;
            for (int i = 0; i < goal; i++) {
                h2 = h2.next;
            }
        }
        end.next = head;
        ListNode result = h2.next;
        h2.next = null;
        return result;


    }

}
