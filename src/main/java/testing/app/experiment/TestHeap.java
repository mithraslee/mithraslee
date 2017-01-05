package testing.app.experiment;

import testing.lib.heap.MaxHeap;
import testing.lib.heap.MinHeap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestHeap {
    public static void run () {
        Set<Integer> set1 = new HashSet<>();
        int size = 10;
        while (set1.size() < size) {
            set1.add((int)(Math.random() * 50));
        }

        MaxHeap<Integer> maxHeap = new MaxHeap<> (set1);
        MinHeap<Integer> minHeap = new MinHeap<> (set1);

        System.out.println ("MaxHeap before heapify: " + maxHeap);
        System.out.println ("MinHeap before heapify: " + minHeap);

        maxHeap.buildHeap();
        minHeap.buildHeap();

        System.out.println ("MaxHeap after heapify: " + maxHeap);
        System.out.println ("MinHeap after heapify: " + minHeap);

        MaxHeap<Integer> maxHeap2 = new MaxHeap<> ();
        for (Integer i : set1) {
            maxHeap2.insertHeap(i);
        }
        // for (Iterator<Integer> it = set1.iterator(); it.hasNext();) {
        //     Integer i = it.next();
        //     maxHeap2.insertHeap(i);
        // }
        System.out.println ("MaxHeap2             : " + maxHeap2);
    }

}
