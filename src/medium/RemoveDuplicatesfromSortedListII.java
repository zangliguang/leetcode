package medium;

/**
 * 82. Remove Duplicates from Sorted List II
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode cur = new ListNode(0);
//        cur.next = head;
//        ListNode result = cur;
//        ListNode pointer1 = head;
//        ListNode pointer2 = head.next;
//        while (pointer2 != null) {
//            if (pointer1.val == pointer2.val) {
//                pointer2 = pointer2.next;
//            } else {
//
//                pointer1 = pointer2;
//                pointer2 = pointer2.next;
//                cur.next = pointer1;
//            }
//        }
//        if (pointer1.next != pointer2) {
//            cur.next = null;
//        }
//
//
//        return result.next;

        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=cur;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
