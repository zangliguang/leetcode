package uncomplete.test.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue<>((Comparator<Integer>) (o1, o2) -> o1 - o2);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(15);
        pq.add(14);
        pq.add(13);
        pq.add(12);
        pq.add(11);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().toString());
        }
    }


}
