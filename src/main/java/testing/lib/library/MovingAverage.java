package testing.lib.library;

import java.util.LinkedList;

/**
 * Created by Yun on 1/15/2017.
 */

/**
 * Moving Average from Data Stream
 *
 *        Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 *        For example,
 *        MovingAverage m = new MovingAverage(3);
 *        m.next(1) = 1
 *        m.next(10) = (1 + 10) / 2
 *        m.next(3) = (1 + 10 + 3) / 3
 *        m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverage {

    private LinkedList<Integer> Q;
    private int cap;
    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        cap = size;
        Q = new LinkedList<>();
        sum = 0;
    }

    public double next(int val) {
        Q.addLast(val);
        sum += val;
        if (Q.size() > cap) {
            sum -= Q.removeFirst();
        }
        return (double)sum/Q.size();
    }
}
