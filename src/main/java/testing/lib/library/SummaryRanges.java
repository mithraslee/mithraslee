package testing.lib.library;

import java.util.*;

/**
 * Created by Yun on 1/14/2017.
 */

/**
 * Data Stream as Disjoint Intervals
 *        Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 *        For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 *        [1, 1]
 *        [1, 1], [3, 3]
 *        [1, 1], [3, 3], [7, 7]
 *        [1, 3], [7, 7]
 *        [1, 3], [6, 7]
 *        Follow up:
 *        What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */
public class SummaryRanges {
    private HashSet<Integer> cache;
    private HashMap<Integer, Interval> startToInterval;
    private HashMap<Integer, Interval> endToInterval;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        cache = new HashSet<>();
        startToInterval = new HashMap<>();
        endToInterval = new HashMap<>();
    }

    public void addNum(int val) {
        if (!cache.contains(val)) {
            cache.add(val);
            if (startToInterval.containsKey(val + 1) && endToInterval.containsKey(val - 1)) {
                Interval prev = endToInterval.remove(val - 1);
                Interval next = startToInterval.remove(val + 1);
                Interval newInterval = new Interval(prev.start, next.end);
                startToInterval.put(newInterval.start, newInterval);
                endToInterval.put(newInterval.end, newInterval);
            } else if (startToInterval.containsKey(val + 1)) {
                Interval next = startToInterval.remove(val + 1);
                Interval newInterval = new Interval(val, next.end);
                startToInterval.put(val, newInterval);
                endToInterval.put(newInterval.end, newInterval);
            } else if (endToInterval.containsKey(val - 1)) {
                Interval prev = endToInterval.remove(val - 1);
                Interval newInterval = new Interval(prev.start, val);
                endToInterval.put(val, newInterval);
                startToInterval.put(newInterval.start, newInterval);
            } else {
                Interval newInterval = new Interval(val, val);
                startToInterval.put(val, newInterval);
                endToInterval.put(val, newInterval);
            }
        }
    }

    public List<Interval> getIntervals() {
        ArrayList<Interval> res = new ArrayList<Interval>(startToInterval.values());
        Collections.sort(res, (a, b) -> a.start - b.start);
        return res;
    }
}
