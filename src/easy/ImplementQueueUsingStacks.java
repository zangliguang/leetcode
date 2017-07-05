package easy;

/**
 * Created by zangliguang on 2017/6/29.
 */

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * <p>
 * Notes:
 * <p>
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(0);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }


    public static class MyQueue {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();

        public MyQueue() {
            s1.clear();
            s2.clear();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            s1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
