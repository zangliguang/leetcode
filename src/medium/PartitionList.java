package medium;

/**
 * 86. Partition List
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lHead = new ListNode(0), lTail = lHead;
        ListNode geHead = new ListNode(0), geTail = geHead;
        ListNode ptr = head, node = null;
        while (ptr != null) {
            node = ptr;
            ptr = ptr.next;
            if (node.val < x) {
                lTail.next = node;
                lTail = node;
            } else {
                geTail.next = node;
                geTail = node;
            }
        }

        lTail.next = geHead.next;
        geTail.next = null;

        return lHead.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
