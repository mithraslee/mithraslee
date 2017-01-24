package testing.lib.library;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yun on 1/16/2017.
 */
public class HitCounter {

    Queue<Integer> Q;

    /** Initialize your data structure here. */
    public HitCounter() {
        Q = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        Q.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (Q.isEmpty()) {
            return 0;
        } else {
            while (!Q.isEmpty() && Q.peek() <= timestamp - 300) {
                Q.poll();
            }
            return Q.size();
        }
    }

}
