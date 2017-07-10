package easy;

/**
 * Created by zangliguang on 2017/7/10.Num160
 */

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * <p>
 * begin to intersect at node c1.
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * <p>
 * Credits:
 * Special thanks to @stellari for adding this problem and creating all test cases.
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return b;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        int alength = 1;
        ListNode b = headB;
        int blength = 1;
        while (headA.next != null) {
            alength++;
            headA = headA.next;
        }
        while (headB.next != null) {
            blength++;
            headB = headB.next;
        }
        int differ = Math.abs(alength - blength);
        if (alength > blength) {
            for (int i = 0; i < differ; i++) {
                a = a.next;
            }
        }
        if (alength < blength) {
            for (int i = 0; i < differ; i++) {
                b = b.next;
            }
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return b;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
