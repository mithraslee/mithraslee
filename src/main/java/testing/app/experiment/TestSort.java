package testing.app.experiment;

import testing.lib.sort_search.Sort;

import java.util.Arrays;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestSort {
    public static void run () {
        int size = 10;
        Integer [] ai = new Integer [size];

        for (int i = 0; i < size; i++) {
            ai[i] = (int)(Math.random() * (size + 1));
        }

        System.out.println("BeforeSort: " + Arrays.asList(ai));
//        Sort.<Integer>bubbleSort(ai, size);
//        Sort.<Integer>cocktailSort(ai, size);
        Sort.<Integer>insertionSort2(ai, size);
//        Sort.<Integer>selectionSort(ai, size);
//        Sort.<Integer>mergeSort(ai, size);
//        Sort.<Integer>selectionSort(ai, size);
        System.out.println("AfterSort: " + Arrays.asList(ai));


        Double [] ad = new Double [size];
        for (int i = 0; i < size; i++) {
            ad[i] = (Math.random() * (size + 1));
        }
        System.out.print("BeforeSort: ");
        System.out.println(Arrays.asList(ad));
        Sort.<Double>selectionSort(ad, size);
        System.out.print("AfterSort: ");
        System.out.println(Arrays.asList(ad));

        Integer [] ai2 = new Integer [size];
        for (int i = 0; i < size; i++)
            ai2[i] = (int)(Math.random() * 200 + 1);
        System.out.println("Before: " + Arrays.asList(ai2));
        Sort.radixSort(ai2, 3);
        System.out.println("After: " + Arrays.asList(ai2));
    }
}
