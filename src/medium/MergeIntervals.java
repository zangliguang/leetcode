package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {


    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = result.get(result.size() - 1);
            Interval next = intervals.get(i);
            if (cur.end >= next.start) {
                cur.end = Math.max(next.end, cur.end);
                result.set(result.size() - 1, cur);
            } else {
                result.add(next);
            }
        }
        return result;
    }


    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
