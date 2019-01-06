package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 925. Long Pressed Name
 * <p>
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 * <p>
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 * <p>
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 * <p>
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 * <p>
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 * <p>
 * <p>
 * Note:
 * <p>
 * name.length <= 1000
 * typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 */
public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) {
            return true;
        }
        ListNode nameHead = getListNode(name.toCharArray());
        ListNode typeHead = getListNode(typed.toCharArray());

        while (null != nameHead) {
            if(typeHead==null){
                return false;
            }
            if(nameHead.c!=typeHead.c||nameHead.val>typeHead.val){
                return false;
            }else{
                nameHead=nameHead.next;
                typeHead=typeHead.next;
            }
        }

        if(typeHead!=null){
            return false;
        }

        return true;
    }

    private ListNode getListNode(char[] nameChars) {
        ListNode nameHead = new ListNode();
        ListNode pointer = new ListNode(nameChars[0], 1);
        nameHead.next = pointer;
        ListNode tailHead = new ListNode();
        for (int i = 1; i < nameChars.length; i++) {
            if (pointer.c == nameChars[i]) {
                pointer.val++;
            } else {
                pointer.next = new ListNode(nameChars[i], 1);
                pointer = pointer.next;
            }
        }
        return nameHead.next;
    }

    public class ListNode {
        int val;
        Character c;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(Character chars, int x) {
            val = x;
            c = chars;
        }

        public ListNode() {

        }
    }
}
