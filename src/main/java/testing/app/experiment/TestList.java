package testing.app.experiment;

import testing.lib.list.SingleList;
import testing.lib.node.ListNodeInt;
import testing.lib.sort_search.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestList {
    public static void run() {
        int range = 30;
        int size1 = 5;
        SingleList<Integer> sList1 = new SingleList<> ();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            int temp = (int)(Math.random() * range + 1);
            list1.add(temp);
            sList1.insertAtEnd(temp);
        }
        System.out.println("sList1: " + sList1);
        System.out.println();

        SingleList<Integer> sList2 = new SingleList<> ();
        for (int i = 0; i < size1; i++) {
            sList2.insertAtFront((int)(Math.random() * range + 1));
        }
        System.out.println("sList2 " + sList2);
        System.out.println();

        SingleList<Integer> sList3 = new SingleList<> ();
        List<Integer> list3 = new ArrayList<> ();
        for (int i = 0; i < size1; i++) {
            int temp = (int)(Math.random() * range + 1);
            list3.add(temp);
            sList3.insertSorted(temp);
        }
        System.out.println("sList3: " + sList3);
        sList3.delete(list3.get(size1/2));
        System.out.println("Remove " + list3.get(size1/2) + " from sList3: " + sList3);
        System.out.println();

        SingleList<Integer> sList4 = new SingleList<> ();
        List<Integer> list4 = new ArrayList<> ();
        for (int i = 0; i < size1; i++) {
            int temp = (int)(Math.random() * range + 1);
            list4.add(temp);
            sList4.insertRecursive(temp);
        }
        System.out.println("sList4: " + sList4);
        sList4.deleteRecursive(list4.get(size1/2));
        System.out.println("Remove " + list4.get(size1/2) + " from sList4: " + sList4);
        System.out.println();

        System.out.println("sList1:          " + sList1);
        sList1.reverse();
        System.out.println("sList1 reversed: " + sList1);
        System.out.println("sList2:          " + sList2);
        sList2.reverse();
        System.out.println("sList2 reversed: " + sList2);
        System.out.println();

        SingleList<Integer> sList5 = new SingleList<> ();
        for (int i = 0; i < 2*size1; i++) {
            int temp = (int)(Math.random() * range + 1);
            sList5.insertAtEnd(temp);
        }
        System.out.println("sList5:                 " + sList5);
        sList5.reverseNByN (2);
        System.out.println("sList5 reversed 2 by 2: " + sList5);
        System.out.println();

        SingleList<Integer> sList6 = new SingleList<> ();
        for (int i = 0; i < 2*size1; i++) {
            int temp = (int)(Math.random() * range + 1);
            sList6.insertAtEnd(temp);
        }
        System.out.println("sList6:                 " + sList6);
        sList6.reverseNByN (3);
        System.out.println("sList6 reversed 3 by 3: " + sList6);
        System.out.println();

        SingleList<Integer> sList7 = new SingleList<> ();
        for (int i = 0; i < 2*size1; i++) {
            int temp = (int)(Math.random() * range + 1);
            sList7.insertAtEnd(temp);
        }
        System.out.println("sList7:                 " + sList7);
        sList7.reverseNByN (4);
        System.out.println("sList7 reversed 4 by 4: " + sList7);
        System.out.println();

        SingleList<Integer> sList7_1 = new SingleList<> ();
        for (int i = 0; i < 2*size1; i++) {
            sList7_1.insertAtEnd(i+1);
        }
        System.out.println("sList7_1:\n\t" + sList7_1);
        sList7_1.reverseBetween (1, 10);
        System.out.println("sList7_1 reversed from 1 to 10:\n\t" + sList7_1);
        System.out.println();

        SingleList<Integer> sList7_2 = new SingleList<> ();
        for (int i = 0; i < 2*size1; i++) {
            sList7_2.insertAtEnd(i+1);
        }
        System.out.println("sList7_2:\n\t" + sList7_2);
        sList7_2.reverseBetween (3, 7);
        System.out.println("sList7_2 reversed from 3 to 7:\n\t" + sList7_2);
        System.out.println();


        SingleList<Integer> sList8 = new SingleList<> ();
        SingleList<Integer> sList8_2 = new SingleList<> ();
        for (int i = 0; i < size1; i++) {
            int temp = (int)(Math.random() * size1 + 1);
            sList8.insertSorted(temp);
            sList8_2.insertSorted2(temp);
        }
        System.out.println("sList8:                       " + sList8);
        System.out.println("sList8_2:                     " + sList8_2);
        System.out.println();

        SingleList<Integer> sList9 = new SingleList<> ();
        for (int i = 0; i < size1; i++) {
            int temp = (int)(Math.random() * size1 + 1);
            sList9.insertSorted(temp);
        }
        System.out.println("sList9:                       " + sList9);
        System.out.println();

        sList8.removeAnotherList(sList9);
        System.out.println("sList8 removed sList9 nodes:  " + sList8);
        System.out.println();

        SingleList<Integer> sList10 = new SingleList<> ();
        for (int i = 0; i < size1; i++) {
            int temp = (int)(Math.random() * size1 + 1);
            sList10.insertSorted(temp);
        }
        System.out.println("sList10:                      " + sList10);

        sList10.removeAnotherListRecursive(sList9);
        System.out.println("sList10 removed sList9 nodes: " + sList10);
        System.out.println();

        int nth = 4;
        System.out.println("The " + nth + "th from the end of sList7 is " + sList7.getNthFromEnd(nth));
        System.out.println();

        SingleList<Integer> sList11 = new SingleList<> ();
        for (int i = 0; i < size1; i++) {
            int temp = (int)(Math.random() * size1 + 1);
            sList11.insertSorted(temp);
        }
        System.out.println("sList11:                           " + sList11);
        SingleList<Integer> sList12 = new SingleList<> ();
        for (int i = 0; i < size1; i++) {
            int temp = (int)(Math.random() * size1 + 1);
            sList12.insertSorted(temp);
        }
        System.out.println("sList12:                           " + sList12);

        SingleList<Integer> sList13 = new SingleList<> ();
        for (int i = 0; i < size1; i++) {
            int temp = (int)(Math.random() * size1 + 1);
            sList13.insertSorted(temp);
        }
        System.out.println("sList13:                           " + sList13);

        sList11.mergeSortedList(sList13);
        System.out.println("sList11 merge sorted with sList13 :" + sList11);
        sList12.mergeSortedList(sList13);
        System.out.println("sList12 merge sorted with sList13 :" + sList12);

        sList12.removeDupSorted();
        System.out.println("sList12 removed duplicated: " + sList12);
        System.out.println();

        SingleList<Integer> sList14 = new SingleList<> ();
        for (int i = 0; i < size1 * 2; i++) {
            int temp = (int)(Math.random() * size1 + 1);
            sList14.insertAtFront(temp);
        }
        System.out.println("sList14:                    " + sList14);
        sList14.removeDupNonSorted();
        System.out.println("sList14 removed duplicated: " + sList14);
        System.out.println();

        SingleList<Integer> sList15 = new SingleList<> ();
        for (int i = 0; i < size1 * 2; i++) {
            int temp = (int)(Math.random() * size1 + 1);
            sList15.insertAtFront(temp);
        }
        System.out.println("sList15:                    " + sList15);
        sList15.removeDupNonSortedUsingSet();
        System.out.println("sList15 removed duplicated: " + sList15);
        System.out.println();

        ListNodeInt sList15_2 = new ListNodeInt(1);
        sList15_2.next = new ListNodeInt(1);
        sList15_2.next.next = new ListNodeInt(1);
        sList15_2.next.next.next = new ListNodeInt(2);
        sList15_2.next.next.next.next = new ListNodeInt(3);
        ListNodeInt sList15_2_result = SingleList.deleteDuplicates(sList15_2);
        while (sList15_2_result != null) {
            System.out.print(sList15_2_result.val + " -> ");
            sList15_2_result = sList15_2_result.next;
        }
        System.out.println();

        int size2 = (int)(Math.random() * 5 + 1);
        SingleList<Integer> sList16 = new SingleList<> ();
        for (int i = 0; i < size2; i++) {
            sList16.insertSorted((int)(Math.random() * 9 + 1));
        }
        System.out.println("sList16:           " + sList16);

        int size3 = (int)(Math.random() * 5 + 1);
        SingleList<Integer> sList17 = new SingleList<> ();
        for (int i = 0; i < size3; i++) {
            sList17.insertSorted((int)(Math.random() * 9 + 1));
        }
        System.out.println("sList17:           " + sList17);

        System.out.println("sList16 + sList17: " + SingleList.addLists(sList16, sList17));
        System.out.println();

        SingleList<Integer> sList18 = new SingleList<> ();
        SingleList<Integer> sList18_2 = new SingleList<> ();
        for (int i = 0; i < 7; i++) {
            sList18.insertSorted(i + 1);
            sList18_2.insertSorted(i + 1);
        }
        System.out.println("sList18:                       " + sList18);
        SingleList.ReOrderList(sList18);
        System.out.println("sList18:                       " + sList18);
        System.out.println("sList18_2:                     " + sList18_2);
        SingleList.ReOrderList2(sList18_2);
        System.out.println("sList18_2:                     " + sList18_2);
        System.out.println();

        SingleList<Integer> sList19 = new SingleList<> ();
        for (int i = 0; i < size1 * 2; i++) {
            int temp = (int)(Math.random() * 100 + 1);
            sList19.insertAtFront(temp);
        }
        System.out.println("sList19:                    " + sList19);
        sList19.insertionSort(sList19);
        System.out.println("sList19 insert sorted:                       " + sList19);
        System.out.println();

        SingleList<Integer> sList20 = new SingleList<> ();
        SingleList<Integer> sList20Dup = new SingleList<> ();
        for (int i = 0; i < size1 * 2; i++) {
            int temp = (int)(Math.random() * 100 + 1);
            sList20.insertAtFront(temp);
            sList20Dup.insertAtFront(temp);
        }
        System.out.println("sList20:                    " + sList20);
        sList20.quickSort();
        System.out.println("sList20 quick sorted:       " + sList20);
        sList20Dup.quickSort2();
        System.out.println("sList20 quick sorted:       " + sList20Dup);
        System.out.println();

        SingleList<Integer> sList21 = new SingleList<> ();
        for (int i = 0; i < size1 * 2; i++) {
            int temp = (int)(Math.random() * 100 + 1);
            sList21.insertAtFront(temp);
        }
        System.out.println("sList21:                    " + sList21);
        Sort.<Integer>quickSort(sList21);
        System.out.println("sList21 quick sorted:       " + sList21);
        System.out.println();

        SingleList<Integer> sList22 = new SingleList<> ();
        for (int i = 0; i < size1 * 2; i++) {
            int temp = (int)(Math.random() * 100 + 1);
            sList22.insertAtFront(temp);
        }
        System.out.println("sList22:                    " + sList22);
        Sort.<Integer>quickSort(sList22);
        System.out.println("sList22 quick sorted:       " + sList22);
        System.out.println();

        SingleList<Integer> sList23 = new SingleList<> ();
        Integer[] att = new Integer[] {0, 0};
//        Integer[] att = new Integer[] {-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,-10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557};
        for (Integer i : att) sList23.insertAtEnd(i);
        System.out.println("sList23:                    " + sList23);
        System.out.println("sList23 is palindrome:      " + sList23.isPalindrome3());
        System.out.println();

        SingleList<Integer> sList24 = new SingleList<> ();
        SingleList<Integer> sList24_2 = new SingleList<> ();
        for (int i = 1; i <= 8; i++) {
            sList24.insertAtEnd(i);
            sList24_2.insertAtEnd(i);
        }
        System.out.println("sList24:                    " + sList24);
        sList24.oddEvenList();
        System.out.println("sList24 after oddEvenList:  " + sList24);
        sList24_2.oddEvenList2();
        System.out.println("sList24_2 after oddEvenList:  " + sList24_2);


        HashMap<Integer, ListNodeInt> M = new HashMap<>();
        ListNodeInt tHead = new ListNodeInt(0);
        ListNodeInt pre = tHead;
        for (int i = 1; i <= 10; i++) {
            ListNodeInt newNode = new ListNodeInt(i);
            pre.next = newNode;
            pre = pre.next;
            M.put(i, newNode);
        }
        for (int i = 1; i <= 5; i++) {
            Integer r = (int)(Math.random() * 10) + 1;
            pre.next = M.get(r);
            SingleList.circleStartDemo(tHead.next, r);
        }
    }

}
