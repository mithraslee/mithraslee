/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.sort_search;

import java.lang.*;
import java.util.*;
import testing.lib.list.SingleList;
import testing.lib.node.ListNode;

/**
 *
 * @author yunl
 */
public class Sort {

    public static <T extends Number> void bubbleSort (T [] a, int size) {
        if (a == null || size <= 1)
            return;
        
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < size - 1; i++) {
                if (Utility.compareItem(a[i], a[i+1]) > 0) {
                    Utility.swap (a, i, i+1);
                    sorted = false;
                }
            }
        } while (!sorted);
    }
    
    public static <T extends Number> void cocktailSort (T [] a, int size) {
        if (a == null || size <= 1)
            return;
        
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < size -1; i++) {
                if (Utility.compareItem(a[i], a[i+1]) > 0) {
                    Utility.swap(a, i, i+1);
                    sorted = false;
                }
            }
            if (sorted)
                break;
            else 
                sorted = true;
            for (int i = size - 2; i >=0; i--) {
                if (Utility.compareItem(a[i], a[i+1]) > 0) {
                    Utility.swap(a, i, i+1);
                    sorted = false;
                }
            }
        } while (!sorted);
    }
    
    public static <T extends Number> void selectionSort (T [] a, int size) {
        if (a == null || size <= 1)
            return;
        
        int i, j, min;
        for (i = 0; i < size - 1; i++) {
            min = i;
            for (j = i + 1; j < size; j++) {
                if (Utility.compareItem(a[j], a[min]) < 0) {
                    min = j;
                }
            }
            if (i != min) {
                Utility.swap(a, i, min);
            }
        }
    }
    
    public static <T extends Number> void insertionSort (T [] a, int size) {
        if (a == null || size <=1)
            return;
        
        for (int i = 1; i < size; i++) {
            T val = a[i];
            int j = i - 1;
            while (j >= 0 && Utility.compareItem(a[j], val) > 0) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = val;
        }
    }

    public static <T extends Number> void insertionSort2 (T [] a, int size) {
        if (a == null || size <=1)
            return;

        for (int i = 1; i < size; i++) {
            T val = a[i];
            int j = i;
            while (j - 1 >= 0 && Utility.compareItem(a[j - 1], val) > 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = val;
        }
    }

    // All the integers inside a[] would be integer of range [1, K]
    public static void coutingSort (int [] a, int size, int K) {
        if (a == null || size <= 1 || K <= 0)
            return;
        
        int [] temp = new int[K];
        Arrays.fill(temp, 0);
        
        for (int i : a) {
            temp[i - 1]++;
        }
        
        int index = 0;
        for (int i = 0; i < K; i++) {
            a[index] = 0;
            while (temp[i] > 0) {
                a[index++] = i + 1;
                temp[i]--;
            }
        }
    }
    
    public static <T extends Number> void mergeSort (T [] a, int size) {
        mergeSort (a, 0, size - 1);
    }
    public static <T extends Number> void mergeSort (T [] a, int b, int e) {
        if (a == null || b < 0 || e < 0 || b >= e)
            return;
        
        int m = b + (e - b)/2;
        mergeSort(a, b, m);
        mergeSort(a, m+1, e);
        Utility.merge(a, b, m, m+1, e);
    }
    
    public static <T extends Number> void quickSort (T [] a, int size) {
        quickSort (a, 0, size - 1);
    }
    public static <T extends Number> void quickSort (T [] a, int b, int e) {
        if (a == null || b < 0 || e < 0 || b >=e)
            return;
        
        int q = Utility.partition(a, b, e, (n1, n2) -> Double.compare(n1.doubleValue(), n2.doubleValue()));
        if (q != -1) {
            quickSort (a, b, q - 1);
            quickSort (a, q + 1, e);
        }
    }
    
    public static void radixSort (Integer [] num, int maxDigitSymbols) {
        int mod = 10;
        int dev = 1;
        LinkedList<Integer>[] counter = new LinkedList[] {
                new LinkedList<>(),
                new LinkedList<>(),
                new LinkedList<>(),
                new LinkedList<>(),
                new LinkedList<>(),
                new LinkedList<>(),
                new LinkedList<>(),
                new LinkedList<>(),
                new LinkedList<>(),
                new LinkedList<>()
            };
        for (int i = 0; i < maxDigitSymbols; i++, dev *= 10, mod *= 10) {
            for (int j = 0; j < num.length; j++) {
                int bucket = (num[j]%mod)/dev;
                counter[bucket].add(num[j]);
            }
            int index = 0;
            for (int j = 0; j < counter.length; j++) {
                Integer value = null;
                while ((value = counter[j].poll()) != null) {
                    num[index++] = value;
                }
            }
        }
    }

    /**
     *
     * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
     * with the colors in the order red, white and blue.
     *
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * Note:
     * You are not suppose to use the library's sort function for this problem.
     *
     * Follow up:
     * A rather straight forward solution is a two-pass algorithm using counting sort.
     * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     * Could you come up with an one-pass algorithm using only constant space?
     */
    public void sortColors(Integer[] A) {
        int len = A.length;
        int endZero = 0;
        int startTwo = len-1;
        int cur = 0;
        while (cur <= startTwo) {
            if (A[cur] == 0) {
                if (cur != endZero) {
                    Utility.swap(A, cur, endZero);
                }
                endZero++;
            } else if (A[cur] == 2) {
                Utility.swap(A, cur, startTwo);
                startTwo--;
            }
            cur++;
        }
    }

    // Sort for SingleList
    static class Pilot <T extends Number> {
        public ListNode<T> pre;
        public ListNode<T> cur;
        public Pilot(ListNode<T> p, ListNode<T> c) { pre = p; cur = c; }
    }
    public static <T extends Number> void quickSort (SingleList<T> sList) {
        ListNode<T> begin = sList.head;
        ListNode<T> end = sList.head;
        while (end.next != null) {
            end = end.next;
        }
        
        quickSortHelper (begin, end);
    }
    private static <T extends Number> void quickSortHelper (ListNode<T> begin, ListNode<T> end) {
        if (begin == null || end == null || begin == end) {
            return;
        }
        
        Pilot<T> p = partition(begin, end);
        
        ListNode<T> b1 = begin;
        ListNode<T> e1 = p.pre;
        ListNode<T> b2 = p.cur.next;
        ListNode<T> e2 = end;

        e1.next = null;
        quickSortHelper (b1, e1);
        e1.next = p.cur;
        quickSortHelper (b2, e2);
        p.cur.next = b2;
    }
    public static <T extends Number> Pilot<T> partition (ListNode<T> begin, ListNode<T> end) {
        if (begin == null || end == null || begin == end)
            return new Pilot<> (null, begin);

        if (begin.compareTo(end) > 0) {
            swapListNode(begin, end);
        }

        ListNode<T> last = end.next;    // This line can be removed. Since end.next is always null
        ListNode<T> prev = begin;
        ListNode<T> cur = begin.next;
        ListNode<T> tail = end;
        
        while (cur != end) {
            if (cur.compareTo(end) <= 0) {
                prev = cur;
                cur = cur.next;
            } else {
                prev.next = cur.next;
                tail.next = cur;
                tail = cur;
                cur = prev.next;
            }
        }
        if (end != tail) {
            swapListNode(end, end.next);
            prev.next = end.next;
            tail.next = end;
            end.next = last;            // This line can be removed. Since end.next is always null
        }
        
        return (prev != null) ? new Pilot<> (prev, prev.next) : new Pilot<> (null, begin);
    }
    private static <T extends Number> void swapListNode (ListNode<T> a, ListNode<T> b) {
        T temp = a.getData();
        a.setData(b.getData());
        b.setData(temp);
    }

    public static <T extends Number> void insertionSort (SingleList<T> sList) {
        if (sList.head == null || sList.head.next == null)
            return;
        ListNode<T> pre = sList.head;
        ListNode<T> cur = sList.head.next;
        while (cur != null) {
            T val = cur.getData();
            ListNode<T> iter = sList.head;
            while (iter != cur) {
                if (iter.compareTo(cur) > 0) {
                    pre.next = cur.next;
                    cur.next = iter.next;
                    iter.next = cur;
                    {
                        T temp = cur.getData();
                        cur.setData(iter.getData());
                        iter.setData(temp);
                    }
                    cur = pre.next;
                    break;
                }
                iter = iter.next;
            }
            if (iter == cur) {
                pre = cur;
                cur = cur.next;
            }
        }
    }
}
