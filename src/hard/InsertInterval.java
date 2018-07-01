package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int start = newInterval.start;
        int end = newInterval.end;
        for (Interval interval : intervals) {
            if (start > interval.end) {
                result.add(interval);
                continue;
            }
            if (end < interval.start) {
                result.add(new Interval(start, end));

                start = interval.start;
                end = interval.end;
                continue;

            }
            start = Math.min(start, interval.start);
            end = Math.max(end, interval.end);
        }
        result.add(new Interval(start, end));
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
