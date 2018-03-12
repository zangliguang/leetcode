package medium;

/**
 * Created by zangliguang on 2017/8/14.Num328
 */

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * <p>
 * Credits:
 * Special thanks to @DjangoUnchained for adding this problem and creating all test cases.
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;
//        l7.next = l8;

        ListNode listNode = oddEvenList(l1);
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode odd = head;
        ListNode oddHead = odd;
        ListNode even = head.next;
        ListNode evenHead = even;
        head = head.next.next;
        if (head.next == null) {
            odd.next = head;
            odd = odd.next;
            odd.next = evenHead;
            evenHead.next = null;
            return oddHead;
        }
        while (head != null && head.next != null) {
            odd.next = head;
            even.next = head.next;
            odd = odd.next;
            even = even.next;
            head = head.next.next;
        }
        if (head != null) {
            odd.next = head;
            odd = odd.next;
            even.next = null;
        }
        odd.next = evenHead;

        return oddHead;
    }
//    public static ListNode oddEvenList(ListNode head) {
//        if (head == null || head.next == null ) return head;
//        ListNode odd=head,ehead=head.next,even=ehead;
//        while(even!=null&&even.next!=null){
//            odd.next=even.next;
//            odd=odd.next;
//            even.next=odd.next;
//            even=even.next;
//        }
//        odd.next=ehead;
//        return head;
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
