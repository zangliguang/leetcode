package easy;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1046 Last Stone Weight
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
       int x,y;
        for(int i : stones) {
            queue.add(i);
        }
        while(queue.size()>1){
            y=queue.poll();
            x=queue.poll();
            if(y>x){
                queue.add(y-x);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
