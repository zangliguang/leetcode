package easy;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 * <p>
 * Input: head = [0]
 * Output: 0
 * Example 3:
 * <p>
 * Input: head = [1]
 * Output: 1
 * Example 4:
 * <p>
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 * <p>
 * Input: head = [0,0]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */
public class ConvertBinaryNumberinaLinkedListtoInteger {


    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int first = n % 10;
            product *= first;
            sum += first;
            n /= 10;
        }
        return product - sum;


    }


    public int getDecimalValue(ListNode head) {
        while (head.val == 0) {
            head = head.next;

            if (head == null) {
                return 0;
            }
        }

        int result = 1;
        while (head.next != null) {
            result *= 2;
            result += head.next.val;
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
