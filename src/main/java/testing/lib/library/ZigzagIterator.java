package testing.lib.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yun on 1/15/2017.
 */

/**
 *Zigzag Iterator
 *
 *        Given two 1d vectors, implement an iterator to return their elements alternately.
 *
 *        For example, given two 1d vectors:
 *
 *        v1 = [1, 2]
 *        v2 = [3, 4, 5, 6]
 *        By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 *
 *        Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 *
 *        Clarification for the follow up question - Update (2015-09-18):
 *        The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
 *
 *        [1,2,3]
 *        [4,5,6,7]
 *        [8,9]
 *        It should return [1,4,8,2,5,9,3,6,7].
 */
public class ZigzagIterator {
    private ArrayList<Integer> L1;
    private ArrayList<Integer> L2;
    private int idx1;
    private int idx2;
    private boolean first;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        L1 = new ArrayList<>(v1);
        L2 = new ArrayList<>(v2);
        idx1 = 0;
        idx2 = 0;
        first = !L1.isEmpty();
    }

    public int next() {
        assert (idx1 < L1.size()) || (idx2 < L2.size());
        int res = first ? L1.get(idx1++) : L2.get(idx2++);
        if (first && idx2 < L2.size()) {
            first = false;
        } else if (!first && idx1 < L1.size()) {
            first = true;
        }
        return res;
    }

    public boolean hasNext() {
        return idx1 < L1.size() || idx2 < L2.size();
    }
}