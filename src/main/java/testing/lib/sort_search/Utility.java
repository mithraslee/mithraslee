/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.sort_search;

import java.util.*;
import static java.lang.Math.*;

/**
 *
 * @author yunl
 */
public class Utility<T extends Number> {
    public static <T extends Number> void swap (T [] a, int i, int j) {
        T val = a[i];
        a[i] = a[j];
        a[j] = val;
    }
    
    public static int compareItem (Number a, Number b)  {
        if (a.doubleValue() > b.doubleValue())
            return 1;
        else if (a.doubleValue() == b.doubleValue())
            return 0;
        else
            return -1;
    }
    
    public static <T extends Number> void merge (T [] a, int b1, int e1, int b2, int e2) {
        List<T> list = new ArrayList<> ();
        
        int index1 = b1;
        int index2 = b2;
        while (index1 <= e1 && index2 <= e2) {
            if (compareItem(a[index1], a[index2]) < 0) {
                list.add(a[index1++]);
            } else {
                list.add(a[index2++]);
            }
        }
        while (index1 <= e1) {
            list.add(a[index1++]);
        }
        while (index2 <= e2) {
            list.add(a[index2++]);
        }

        int index = Math.min(b1, b2);
        for (T val : list) {
            a[index++] = val;
        }
    }

    public static <T extends Number> int partition (T [] a, int b, int e, Comparator<T> camp) {
        if (a == null || b < 0 || e < 0 || b > e)
            return -1;

        int q = b + (int)(Math.random() * (e - b + 1));
        if (q != e) swap(a, q, e);

        int low = b;
        int high = e;
        boolean lToH = true;

        while (low < high) {
            if (camp.compare(a[low], a[high]) > 0) {
                swap(a, low, high);
                lToH = !lToH;
            } else {
                if (lToH) low++;
                else high--;
            }
        }

        return low;
    }
//    public static <T extends Number> int partition (T [] a, int b, int e) {
//        if (a == null || b < 0 || e < 0 || b >= e)
//            return -1;
//
//        int q = b + (int)(Math.random() * (e - b + 1));
//        if (q != e)
//            swap(a, q, e);
//
//        T val = a[e];
//        int low = b;
//        int high = e;
//        boolean lToH = true;
//
//        while (low < high) {
//            if (lToH) {
//                if (compareItem(a[low], val) > 0) {
//                    swap (a, low, high);
//                    lToH = false;
//                } else
//                    low++;
//            } else {
//                if (compareItem(a[high], val) < 0) {
//                    swap (a, low, high);
//                    lToH = true;
//                } else
//                    high--;
//            }
//        }
//
//        return low;
//    }
}
