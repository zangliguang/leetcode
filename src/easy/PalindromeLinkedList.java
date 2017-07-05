package easy;

/**
 * Created by zangliguang on 2017/7/4.Num243
 */

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(l));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode head1 = head;
        ListNode mid = head;
        ListNode tail = head;
        while (tail.next != null && tail.next.next != null) {
            mid = mid.next;
            tail = tail.next.next;
        }

        if (tail.next != null) {
            mid = mid.next;
        }
        tail = revert(mid);
        while (head1 != mid) {
            if (head1.val != tail.val) {
                return false;
            }
            head1 = head1.next;
            tail = tail.next;
        }
        return true;

    }

    private static ListNode revert(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
