/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.sort_search;

import java.lang.*;
import java.util.*;

/**
 *
 * @author yunl
 */
//public class Search<T extends Number> {
public class Search {

    // Opposite to linearSearch()
    static public <T extends Number> T findKthLargest(T [] nums, int k) {
        int len = nums.length;
        if (len < k) return null;

        return helper(nums, 0, len-1, k);
    }
    static private <T extends Number> T helper(T [] a, int b, int e, int k) {
        if (a == null || b < 0 || e < 0 || k < 0 || b > e || (e-b+1) < k) return null;
        int q = Utility.partition(a, b, e, (n1, n2) -> -Double.compare(n1.doubleValue(), n2.doubleValue()));

        int qth = q - b + 1;
        if (qth == k) return a[q];
        if (qth > k) {
            return helper(a, b, q - 1, k);
        } else {
            return helper(a, q + 1, e, k - qth);
        }
    }
//    static private int partition(int[] a, int b, int e) {
//        if (a == null || b < 0 || e < 0 || b > e)
//            return -1;
//
//        int q = b + (int)(Math.random() * (e - b + 1));
//        if (q != e) swap(a, q, e);
//
//        int low = b, high = e;
//        boolean lToH = true;
//
//        while(low < high) {
//            if (a[low] < a[high]) {
//                swap(a, low, high);
//                lToH = !lToH;
//            } else {
//                if (lToH) low++;
//                else high--;
//            }
//        }
//        return low;
//    }

    public static <T extends Number> int linearSearch (T [] a, int size, int kth) {
        return linearSearch (a, 0, size - 1, kth);
    }
    public static <T extends Number> int linearSearch (T [] a, int b, int e, int kth) {
        if (a == null || b < 0 || e < 0 || kth < 0 || b > e || (e-b+1) < kth) {
            System.out.println("b: " + b + "; e: " + e + "; kth: " + kth);
            if (a == null) System.out.println("a == null");
            return -1;
        }
        int q = Utility.partition(a, b, e, (n1, n2) -> Double.compare(n1.doubleValue(), n2.doubleValue()));
        int ith = q - b + 1;
        if (ith == kth) {
            return q;
        } else if (ith > kth) {
            return linearSearch (a, b, q-1, kth);
        } else {
            return linearSearch (a, q + 1, e, kth - ith);
        }
    }
    
    public static <T extends Number> int binarySearchRecursive (T [] a, int size, T val) {
        return binarySearchRecursive (a, 0, size - 1, val);
    }
    public static <T extends Number> int binarySearchRecursive (T [] a, int b, int e, T val) {
        if (a == null || b < 0 || e < 0 || b > e)
            return -1;
        int m = (b + e)/2;
        if (Utility.compareItem(a[m], val) == 0) {
            return m;
        } else if (Utility.compareItem(a[m], val) > 0) {
            return binarySearchRecursive (a, b, m - 1, val);
        } else {
            return binarySearchRecursive (a, m + 1, e, val);
        }
    }
    
    public static <T extends Number> int binarySearchIterative (T [] a, int size, T val) {
        return binarySearchIterative (a, 0, size - 1, val);
    }
    public static <T extends Number> int binarySearchIterative (T [] a, int b, int e, T val) {
        if (a == null || b < 0 || e < 0 || b > e)
            return -1;
        
        while (b <= e) {
            int m = (b+e)/2;
            if (Utility.compareItem(a[m], val) == 0) {
                return m;
            } else if (Utility.compareItem(a[m], val) > 0) {
                e = m - 1;
            } else {
                b = m + 1;
            }
        }
        return -1;
    }
    
    public static <T extends Number> int binarySearchForRotation(T [] a, int b, int e, T val) {
        if (a == null || b < 0 || e < 0 || b > e) 
            return -1;
        
        while (b < e) {
            int m = (b+e)/2;
            if (Utility.compareItem(a[m], val) == 0) {
                return m;
            } else if (Utility.compareItem(a[m], val) > 0) {
                if (Utility.compareItem(a[m], a[b]) > 0 && Utility.compareItem(a[b], val) > 0) {
                    b = m + 1;
                } else {
                    e = m - 1;
                }
            } else {
                if (Utility.compareItem(a[m], a[e]) < 0 && Utility.compareItem(a[e], val) < 0) {
                    e = m - 1;
                } else {
                    b = m + 1;
                }
            }
        }
        
        return -1;
    }
}


