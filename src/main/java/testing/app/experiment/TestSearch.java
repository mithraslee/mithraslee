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

        System.out.println();
        int[] nums = new int[]{1,2,2,3,4,6,6,6,13,18};
        System.out.println(Search.lowerBound(nums, 6)); // 5
        System.out.println(Search.lowerBound2(nums, 6)); // 5
        System.out.println(Search.upperBound(nums, 6)); // 7
        System.out.println(Search.upperBound2(nums, 6)); // 7
        System.out.println();
        System.out.println(Search.lowerBound(nums, 7)); // 8
        System.out.println(Search.lowerBound2(nums, 7)); // 8
        System.out.println(Search.upperBound(nums, 7)); // 7
        System.out.println(Search.upperBound2(nums, 7)); // 7
        System.out.println();
        System.out.println(Search.lowerBound(nums, 5)); // 5
        System.out.println(Search.lowerBound2(nums, 5)); // 5
        System.out.println(Search.upperBound(nums, 5)); // 4
        System.out.println(Search.upperBound2(nums, 5)); // 4

        Search.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5);
        Search.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7);
        Search.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        Search.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10);
        Search.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 3);
        Search.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        Search.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 9);
        Search.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 11);

        int[] testArr2 = new int[]{1, 3, 4, 5, 8, 9, 13, 18};
        for (int i = 0; i < 20; i++) {
            Search.searchForClosestDemo(testArr2, i);
        }
    }
}
