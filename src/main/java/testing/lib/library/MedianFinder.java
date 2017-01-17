package testing.lib.library;

import java.util.PriorityQueue;

/**
 * Created by Yun on 1/14/2017.
 */

/**
 * Find Median from Data Stream
 *         Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 *         Examples:
 *         [2,3,4] , the median is 3
 *
 *         [2,3], the median is (2 + 3) / 2 = 2.5
 *
 *         Design a data structure that supports the following two operations:
 *
 *         void addNum(int num) - Add a integer number from the data stream to the data structure.
 *         double findMedian() - Return the median of all elements so far.
 *         For example:
 *
 *         add(1)
 *         add(2)
 *         findMedian() -> 1.5
 *         add(3)
 *         findMedian() -> 2
 */
public class MedianFinder {

    private PriorityQueue<Integer> upperHeap;
    private PriorityQueue<Integer> lowerHeap;

    private boolean isEmpty() {
        return lowerHeap.isEmpty() && upperHeap.isEmpty();
    }

    public MedianFinder() {
        upperHeap = new PriorityQueue<>((a, b) -> a - b);
        lowerHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (isEmpty()) {
            lowerHeap.add(num);
        } else {
            if (num < lowerHeap.peek()) {
                lowerHeap.add(num);
            } else {
                upperHeap.add(num);
            }
            rebalance();
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (isEmpty()) {
            return 0.0;
        }
        if (upperHeap.size() == lowerHeap.size()) {
            return ((double)upperHeap.peek() + (double)lowerHeap.peek())/2.0;
        } else {
            return lowerHeap.peek();
        }
    }

    private void rebalance() {
        if (!isEmpty()) {
            while (upperHeap.size() > lowerHeap.size()) {
                lowerHeap.add(upperHeap.poll());
            }
            while (lowerHeap.size() > upperHeap.size() + 1) {
                upperHeap.add(lowerHeap.poll());
            }
        }
    }
}
