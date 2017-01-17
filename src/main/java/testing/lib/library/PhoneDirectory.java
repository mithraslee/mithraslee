package testing.lib.library;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yun on 1/13/2017.
 */
public class PhoneDirectory {
    private int max;
    private HashSet<Integer> used;
    private Queue<Integer> Q;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        used = new HashSet<>();
        Q = new LinkedList<>();
        for (int i = 0; i < max; i++) {
            Q.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (Q.isEmpty()) {
            return -1;
        } else {
            used.add(Q.peek());
            return Q.poll();
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number < max && used.contains(number)) {
            used.remove(number);
            Q.add(number);
        }
    }
}
