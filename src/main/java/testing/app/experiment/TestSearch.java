package testing.app.experiment;

import testing.lib.sort_search.Search;
import testing.lib.sort_search.Sort;

import java.util.Arrays;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestSearch {
    public static void run () {
        int size = 10;
        Integer [] ai = new Integer [size];

        for (int i = 0; i < size; i++) {
            ai[i] = (int)(Math.random() * (size + 1));
        }

        System.out.print("ai[]: ");
        System.out.println(Arrays.asList(ai));
//        System.out.print("Input the num_th to find: ");
        int kth = 5;
//        int kth = Integer.parseInt(System.console().readLine());
        int q = Search.<Integer>linearSearch(ai, size, kth);
        Sort.<Integer>quickSort(ai, size);
        System.out.println(Arrays.asList(ai) + "; q = " + q);
        System.out.println("The " + kth + "th element in ai[] is: " + ai[q].toString() + " at position " + q);

        int val1 = 9;
        System.out.println("Search for " + val1);
        int q1 = Search.binarySearchIterative(ai, size, val1);
        if (q1 == -1)
            System.out.println("Cannot find " + val1);
        else
            System.out.println("a[" + q1 + "] = " + val1);

        int val2 = 1;
        System.out.println("Search for " + val2);
        int q2 = Search.binarySearchRecursive(ai, size, val2);
        if (q2 == -1)
            System.out.println("Cannot find " + val2);
        else
            System.out.println("a[" + q2 + "] = " + val2);

        Integer[] testArr = {2, 1};
        int k = Search.<Integer>findKthLargest(testArr, 1);
        System.out.println(k);
    }
}
