package easy;

import java.util.PriorityQueue;

/**
 * 703 Kth Largest Element in a Stream
 */
public class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : nums)
            add(n);
    }

    public int add(int val) {
        if (q.size() < k)
            q.offer(val);
        else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}
