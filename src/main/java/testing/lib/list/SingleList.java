/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.list;

import java.util.*;
import testing.lib.node.*;
/**
 *
 * @author yunl
 */
public class SingleList<T extends Number> {
    public ListNode<T> head;
    
    public SingleList () {
        head = null;
    }
    
    public void insertAtEnd (T val)  {
        ListNode<T> newNode = new ListNode<> (val);
        
        ListNode<T> pre = null;
        ListNode<T> cur = head;
        
        while (cur != null) {
            pre = cur;
            cur = cur.next;
        }
        
        if (pre == null) {
            head = newNode;
        } else {
            pre.next = (newNode);
        }
    }
    public void insertAtFront (T val) {
        ListNode<T> newNode = new ListNode<> (val);
        
        newNode.next = head;
        head = newNode;
    }
    public void insertSorted (T val) {
        ListNode<T> newNode = new ListNode<> (val);
        
        ListNode<T> pre = null;
        ListNode<T> cur = head;
        
        while (cur != null) {
            if (cur.compareTo(val) < 0) {
                pre = cur;
                cur = cur.next;
            } else {
                if (pre == null) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    newNode.next = cur;
                    pre.next = newNode;
                }
                return;
            }
        }
        
        if (pre == null) {
            head = newNode;
        } else {
            pre.next = newNode;
        }
    }
    public void insertSorted2 (T val) {
        ListNode<T> newNode = new ListNode<T>(val);
        ListNode<T> newHead = new ListNode<T>(val);
        newHead.next = head;
        ListNode<T> pre = newHead;
        ListNode<T> cur = head;

        while (cur != null) {
            if (cur.compareTo(val) < 0) {
                pre = cur;
                cur = cur.next;
            } else {
                pre.next = newNode;
                newNode.next = cur;
                break;
            }
        }
        pre.next = newNode;
        head = newHead.next;
    }
    public void insertRecursive (T val) {
        head = insertRecursiveHelper (head, val);
    }
    private ListNode<T> insertRecursiveHelper (ListNode<T> tn, T val) {
        if (tn == null || tn.compareTo(val) > 0) {
            ListNode<T> newNode = new ListNode<> (val, tn);
            return newNode;
        }
        tn.next = insertRecursiveHelper(tn.next, val);
        return tn;
    }
    
    public boolean delete (T val) {
        ListNode<T> cur = head;
        ListNode<T> pre = null;
        
        while (cur != null) {
            if (cur.compareTo(val) == 0) {
                if (pre == null) {
                    head = null;
                } else {
                    pre.next = cur.next;
                }
                return true;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return false;
    }
    public boolean delete2 (T val) {
        ListNode<T> pre = new ListNode<>(val, head);
        ListNode<T> cur = head;
        while (cur != null) {
            if (cur.compareTo(val) == 0) {
                pre.next = cur.next;
                head = pre.next;
                return true;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return false;
    }
    public void deleteRecursive (T val) {
        head = deleteRecursiveHelper (head, val);
    }
    private ListNode<T> deleteRecursiveHelper (ListNode<T> n, T val) {
        if (n == null) {
            return null;
        }
        if (n.compareTo(val) == 0) {
            return n.next;
        }
        n.next = deleteRecursiveHelper (n.next, val);
        return n;
    }
    
    public void reverse () {
        ListNode<T> pre = null;
        ListNode<T> cur = head;
        
        while (cur != null) {
            ListNode<T> temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head = pre;
    }
    public void reverseRecursive () {
        head = reverseRecursiveHelper (head);
    }
    private ListNode<T> reverseRecursiveHelper (ListNode<T> n) {
        if (n == null || n.next == null)
            return n;
        ListNode<T> headNode = reverseRecursiveHelper (n.next);
        n.next.next = n;
        n.next = null;
        return headNode;
    }
    
    public void reverseNByN (int N) {
        head = reverseNByNHelper (head, N);
    }
    private ListNode<T> reverseNByNHelper (ListNode<T> n, int N) {
        if (n == null)
            return null;
        ListNode<T> pre = null;
        ListNode<T> cur = n;
        int K = N;
        while (K > 0 && cur != null) {
            ListNode<T> temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            K--;
        }
        n.next = reverseNByNHelper (cur, N);
        n = pre;
        return n;        
    }

    /**
     * Reverse Linked List II - Accepted
     *  
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * For example:
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * Return 1->4->3->2->5->NULL.
     *
     * Note:
     * Given m, n satisfy the following condition:
     *         1 ≤ m ≤ n ≤ length of list.
     */
    public void reverseBetween(int m, int n) {
        if (head == null || m < 1 || n < 1 || m > n) {
            return;
        }

        ListNode<T> dummy = new ListNode<>(head.getData());
        dummy.next = head;
        ListNode<T> pre = dummy;
        ListNode<T> start = head;

        while (m > 1 && start != null) {
            pre = start;
            start = start.next;
            m--;
            n--;
        }
        assert start != null;
        ListNode<T> end = start;
        while (n > 1 && end != null) {
            end = end.next;
            n--;
        }
        assert end != null;

        ListNode<T> next = end.next;
        end.next = null;
        ListNode<T> tPre = null;
        ListNode<T> cur = start;

        while (cur != null) {
            ListNode<T> tmp = cur.next;
            cur.next = tPre;
            tPre = cur;
            cur = tmp;
        }

        pre.next = tPre;
        start.next = next;

        head = dummy.next;
    }

    public void removeAnotherList (SingleList<T> sList) {
        ListNode<T> pre = null;
        ListNode<T> cur = head;
        ListNode<T> cur2 = sList.head;
        
        while (cur != null && cur2 != null) {
            if (cur.compareTo(cur2) == 0) {
                if (pre == null) {
                    cur = cur.next;
                    head = cur;
                } else {
                    pre.next = cur.next;
                    cur = cur.next;
                }
            } else if (cur.compareTo(cur2) < 0) {
                pre = cur;
                cur = cur.next;
            } else {
                cur2 = cur2.next;
            }
        }
    }
    public void removeAnotherListRecursive (SingleList<T> sList) {
        head = removeAnotherListRecursiveHelper (head, sList.head);
    }
    private ListNode<T> removeAnotherListRecursiveHelper (ListNode<T> n1, ListNode<T> n2) {
        if (n1 == null || n2 == null)
            return n1;
        
        if (n1.compareTo(n2) == 0) {
            return removeAnotherListRecursiveHelper (n1.next, n2);
        } else if (n1.compareTo(n2) > 0) {
            return removeAnotherListRecursiveHelper (n1, n2.next);
        } else {
            n1.next = removeAnotherListRecursiveHelper (n1.next, n2);
            return n1;
        }
    }
    
    public int length () {
        int len = 0;
        ListNode<T> n = head;
        while (n != null) {
            len++;
            n = n.next;
        }
        return len;
    }
    
    public T getNthFromEnd (int nth) {
        int len = this.length();
        if (nth > len) {
            System.out.println("This list's length(" + len + ") is smaller than " + nth);
            return null;
        }
        ListNode<T> pilot = head;
        ListNode<T> cur = head;
        int kth = 0;
        while (pilot != null) {
            if (kth < nth) {
                kth++;
            } else {
                cur = cur.next;
            }
            pilot = pilot.next;
        }
        return cur.getData();
    }
    
    public void mergeSortedList (SingleList<T> sList) {
        ListNode<T> pre = null;
        ListNode<T> cur = head;
        ListNode<T> cur2 = sList.head;
        
        while (cur != null && cur2 != null) {
            if (cur.compareTo(cur2) < 0) {
                pre = cur;
                cur = cur.next;
            } else {
                // cur.getData() >= cur2.getData()
                ListNode<T> temp = new ListNode<> (cur2.getData());
                
                if (pre == null) {
                    head = temp;
                    temp.next = cur;
                    pre = temp;
                } else {
                    pre.next = temp;
                    temp.next = cur;
                    pre = temp; 
                }
                cur2 = cur2.next;
            }
        }
        while (cur2 != null) {
            ListNode<T> temp = new ListNode<> (cur2.getData());
            
            if (pre == null) {
                head = temp;
                pre = head;
            } else {
                pre.next = temp;
                pre = temp;
            }
            cur2 = cur2.next;
        }
    }
    public void mergeSortedListRecursive (SingleList<T> sList) {
        head = mergeSortedListRecursiveHelper (head, sList.head);
    }
    private ListNode<T> mergeSortedListRecursiveHelper (ListNode<T> n1, ListNode<T> n2) {
        if (n2 == null)
            return n1;
        if (n1 == null) {
            ListNode<T> newNode = new ListNode<> (n2.getData());
            newNode.next = mergeSortedListRecursiveHelper (null, n2.next);
            return newNode;
        }
        
        if (n1.compareTo(n2) <= 0) {
            n1.next = mergeSortedListRecursiveHelper (n1.next, n2);
            return n1;
        } else {
            ListNode<T> newNode = new ListNode<> (n2.getData());
            newNode.next = mergeSortedListRecursiveHelper (n1, n2.next);
            return newNode;
        }
    }
    
    public void removeDupSorted () {
        ListNode<T> cur = head;
        
        while (cur != null) {
            ListNode<T> next = cur.next;
            
            while (next != null && next.compareTo(cur) == 0) {
                next = next.next;
            }
            
            cur.next = next;
            cur = cur.next;
        }
    }
    
    public void removeDupNonSorted () {
        if (head == null)
            return;
        
        ListNode<T> tail = head;
        ListNode<T> cur = tail.next;
        
        while (cur != null) {
            tail.next = null;
            ListNode<T> iter = head;
            while (iter != null) {
                if (iter.compareTo(cur) == 0) {
                    break;
                }
                iter = iter.next;
            }
            
            if (iter == null) {
                tail.next = cur;
                tail = cur;
            }
            cur = cur.next;
        }
        tail.next = null;
    }
    public void removeDupNonSortedUsingSet () {
        Set<T> set = new HashSet<> ();
        set.add (head.getData());
        
        ListNode<T> pre = head;
        ListNode<T> cur = head.next;
        while (cur != null) {
            if (set.contains(cur.getData())) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                set.add(cur.getData());
                pre = cur;
                cur = cur.next;
            }
        }
    }

    /**
     * Remove Duplicates from Sorted List II
     *
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
     *         For example,
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * Given 1->1->1->2->3, return 2->3.
     */
    public static ListNodeInt deleteDuplicates(ListNodeInt head) {
        ListNodeInt dummy = new ListNodeInt(0);
        dummy.next = head;
        ListNodeInt pre = dummy;
        ListNodeInt cur = head;

        while (cur != null) {
            boolean delete = false;
            while (cur.next != null && cur.val == cur.next.val) {
                delete = true;
                cur = cur.next;
            }
            if (delete) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = pre.next;
        }
        return dummy.next;
    }

    /* 12.6 You have two numbers represented by a linked list, where each node contains a single  digit. Write a function that adds the two numbers and returns the sum as a linked list.
    EXAMPLE:  
    input: (3 -> 1 -> 5), (5 -> 9 -> 2)
    output: 9 -> 0 -> 7 
    ### */
    // 这种题只要小心别忘记carry就不会出问题
    public static SingleList<Integer> addLists (SingleList<Integer> sList1, SingleList<Integer> sList2) {
        Stack<Integer> s1 = new Stack<> ();
        Stack<Integer> s2 = new Stack<> ();
        
        ListNode<Integer> cur1 = sList1.head;
        ListNode<Integer> cur2 = sList2.head;
        
        while (cur1 != null) {
            s1.add(cur1.getData());
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            s2.add(cur2.getData());
            cur2 = cur2.next;
        }
        
        SingleList<Integer> sListAdded = new SingleList<> ();
        int sum = 0;
        int carry = 0;
        
        while (!s1.isEmpty() && !s2.isEmpty()) {
            sum = s1.pop() + s2.pop() + carry;
            sListAdded.insertAtFront(sum%10);
            carry = sum/10;
        }
        while (!s1.isEmpty()) {
            sum = s1.pop() + carry;
            sListAdded.insertAtFront(sum%10);
            carry = sum/10;
        }
        while (!s2.isEmpty()) {
            sum = s2.pop() + carry;
            sListAdded.insertAtFront(sum%10);
            carry = sum/10;
        }
        if (carry != 0) {
            sListAdded.insertAtFront(carry);
        }
        
        return sListAdded;
    }
    
    
    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→… 
     * You must do this in-place without altering the nodes' values.
     */
    public static SingleList<Integer> ReOrderList (SingleList<Integer> sList) {
        ListNode<Integer> oneStep = sList.head;
        ListNode<Integer> twoStep = sList.head;
        
        while (oneStep != null && twoStep != null && twoStep.next != null) {
            twoStep = twoStep.next;
            if (twoStep.next == null) {
                break;
            }
            oneStep = oneStep.next;
            twoStep = twoStep.next;
        }
        
        if (oneStep == twoStep)
            return sList;
        
        ListNode<Integer> newHead = oneStep.next;
        oneStep.next = null;
        
        SingleList<Integer> tempList = new SingleList<> ();
        tempList.head = newHead;
        tempList.reverseRecursive();
        
        ListNode<Integer> cur2 = tempList.head;
        ListNode<Integer> cur1 = sList.head;
        
        boolean odd = true;
        while (cur1 != null && cur2 != null) {
            ListNode<Integer> temp1 = cur1.next;
            ListNode<Integer> temp2 = cur2.next;
            
            cur1.next = cur2;
            cur2.next = temp1;
            
            cur1 = temp1;
            cur2 = temp2;
        }
        
        if (cur2 != null) 
            cur1.next = cur2;
        
        return sList;
    }
    public static SingleList<Integer> ReOrderList2 (SingleList<Integer> sList) {
        ListNode<Integer> oneStep = sList.head;
        ListNode<Integer> twoStep = sList.head;
        while (twoStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next;
            twoStep = twoStep.next;
        }
        if (oneStep == twoStep) {
            return sList;
        }
        ListNode<Integer> newHead = oneStep.next;
        oneStep.next = null;

        ListNode<Integer> newPre = null;
        ListNode<Integer> newCur = newHead;
        while (newCur != null) {
            ListNode<Integer> tmp = newCur.next;
            newCur.next = newPre;
            newPre = newCur;
            newCur = tmp;
        }

        ListNode<Integer> cur1 = sList.head;
        ListNode<Integer> cur2 = newPre;

        while(cur1 != null && cur2 != null) {
            ListNode<Integer> temp1 = cur1.next;
            ListNode<Integer> temp2 = cur2.next;

            cur1.next = cur2;
            cur2.next = temp1;
            cur1 = temp1;
            cur2 = temp2;
        }
        if (cur2 != null) {
            cur1.next = cur2;
        }
        return sList;
    }

    /**
     * Insertion Sort for LinkedList
     */
    public void insertionSort (SingleList<T> sList) {
        if (head == null || head.next == null)
            return;
        ListNode<T> pre = head;
        ListNode<T> cur = head.next;
        while (cur != null) {
            ListNode<T> iter = head;
            while (iter != cur) {
                if (iter.compareTo(cur) > 0) {
                    pre.next = cur.next;
                    cur.next = iter.next;
                    iter.next = cur;
                    swapNodeValue(cur, iter);
                    cur = pre.next; // In this case, pre does not need to change, cur is already changed in while.
                    break;
                }
                iter = iter.next;
            }
            if (iter == cur) {      // So, here we only need to handle "iter == cur" case
                pre = cur;
                cur = cur.next;
            }
        }
    }

//    public ListNode partition3(ListNode head, int x) {
//        ListNode smallHead = new ListNode(0);
//        ListNode smallCur = smallHead;
//        ListNode largeHead = new ListNode(0);
//        ListNode largeCur = largeHead;
//
//        ListNode cur = head;
//
//        while (cur != null) {
//            ListNode next = cur.next;
//            if (cur.val >= x) {
//                largeCur.next = cur;
//                largeCur = cur;
//            } else {
//                smallCur.next = cur;
//                smallCur = cur;
//            }
//            cur.next = null;
//            cur = next;
//        }
////        if (smallHead.next == null) {
////            return largeHead.next;
////        }
//        smallCur.next = largeHead.next;
//
//        return smallHead.next;
//    }

    class Pilot {
        public ListNode<T> pre;
        public ListNode<T> cur;
        public Pilot(ListNode<T> p, ListNode<T> c) { pre = p; cur = c; }
    }
    public Pilot partition (ListNode<T> begin, ListNode<T> end) {
        if (begin == null || end == null || begin == end)
            return new Pilot (null, begin);

        // Swap begin & end if needed, so that the begin node can be untouched
        if (begin.compareTo(end) > 0) {
            swapNodeValue(begin, end);
        }
        
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
                cur.next = null;
                cur = prev.next;
            }
        }
        if (end != tail) {      // Put the end node the the end of the list
            swapNodeValue(end, end.next);
            prev.next = end.next;
            tail.next = end;
            end.next = null;    // important!!!
        }
        
        return new Pilot (prev, prev.next);
    }
    public void quickSort () {
        ListNode<T> begin = head;
        ListNode<T> end = head;
        while (end.next != null) {
            end = end.next;
        }
        
        quickSortHelper (begin, end);
    }
    private void quickSortHelper (ListNode<T> begin, ListNode<T> end) {
        if (begin == null || end == null || begin == end) {
            return;
        }
        
        Pilot p = partition(begin, end);
        
        // Avoid function return pointing way.
        // Use the most intuitive manner
        ListNode<T> b1 = begin;
        ListNode<T> e1 = p.pre;
        ListNode<T> b2 = p.cur.next;
        ListNode<T> e2 = end;

        e1.next = null; // important!!! D-A-C
        quickSortHelper (b1, e1);
        e1.next = p.cur;
        quickSortHelper (b2, e2);
        p.cur.next = b2;
    }

    // 2nd Version of QuickSort for List
    // The 1st version seems to be better though.
    class BeginEndOfList {
        public ListNode<T> begin;
        public ListNode<T> end;
        public BeginEndOfList(ListNode<T> b, ListNode<T> e) {
            begin = b;
            end = e;
        }
    }
    class PartitionedResult {
        BeginEndOfList l1;
        BeginEndOfList l2;
        public ListNode<T> pilot;

        public PartitionedResult(BeginEndOfList ll1, BeginEndOfList ll2, ListNode<T> p) {
            l1 = ll1;
            l2 = ll2;
            pilot = p;
        }
    }
    public void quickSort2 () {
        ListNode<T> begin = head;
        ListNode<T> end = head;
        while (end.next != null)
            end = end.next;
        BeginEndOfList be = quickSortHelper2(new BeginEndOfList(begin, end));
        head = be.begin;
    }
    private BeginEndOfList quickSortHelper2 (BeginEndOfList beginEnd) {
//        if (beginEnd.begin == null || beginEnd.end == null)
//            return new BeginEndOfList(null, null);
        if (beginEnd.begin == beginEnd.end)
            return beginEnd;

        PartitionedResult pRes = partition2(beginEnd);

        if (pRes == null) return null;

        ListNode<T> newBegin = null;
        ListNode<T> newEnd = null;

        if (pRes.l1 != null) {
            BeginEndOfList l1 = quickSortHelper2(pRes.l1);
            newBegin = l1.begin;
            l1.end.next = pRes.pilot;
        } else {
            newBegin = pRes.pilot;
        }

        if (pRes.l2 != null) {
            BeginEndOfList l2 = quickSortHelper2(pRes.l2);
            pRes.pilot.next = l2.begin;
            newEnd = l2.end;
        } else {
            newEnd = pRes.pilot;
        }
        return new BeginEndOfList(newBegin, newEnd);
    }

    private PartitionedResult partition2(BeginEndOfList beginEnd) {
        if (beginEnd.begin == null || beginEnd.end == null)
            return null;
        if (beginEnd.begin == beginEnd.end) {
            return new PartitionedResult(null, null, beginEnd.begin);
        }

        ListNode<T> cur = beginEnd.begin;
        ListNode<T> b1 = null;
        ListNode<T> e1 = null;
        ListNode<T> b2 = null;
        ListNode<T> e2 = null;
        ListNode<T> p = beginEnd.end;

        while (cur != beginEnd.end) {
            ListNode<T> tmp = cur.next;
            if (cur.compareTo(p) > 0) {
                if (b2 == null) {
                    b2 = cur;
                    e2 = cur;
                } else {
                    e2.next = cur;
                    e2 = cur;
                }
            } else {
                if (b1 == null) {
                    b1 = cur;
                    e1 = cur;
                } else {
                    e1.next = cur;
                    e1 = cur;
                }
            }
            cur.next = null;
            cur = tmp;
        }
        BeginEndOfList l1 = null;
        if (b1 != null) l1 = new BeginEndOfList(b1, e1);
        BeginEndOfList l2 = null;
        if (b2 != null) l2 = new BeginEndOfList(b2, e2);
        return new PartitionedResult(l1, l2, p);
    }

    private void swapNodeValue(ListNode<T> n1, ListNode<T> n2) {
        T tmp = n1.getData();
        n1.setData(n2.getData());
        n2.setData(tmp);
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder ();
        
        ListNode<T> cur = head;
        
        while (cur != null) {
            sb.append(cur.getData().toString()).append(" -> ");
            cur = cur.next;
        }
        sb.append("null");
        
        return sb.toString();
    }

    public boolean isPalindrome() {
        LinkedList<Number> list = new LinkedList<>();
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            list.add(cur.getData());
            cur = cur.next;
            count++;
        }
        if (count < 2) return true;

        ArrayList<Number> arr = new ArrayList<>(list);

        int start = 0, end = arr.size()-1;
        while (start <= end) {
            if (!arr.get(start++).equals(arr.get(end--))) {
                return false;
            }
        }
        return true;
    }
    // Better solution
    public boolean isPalindrome2() {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        Stack S = new Stack();
        S.push(head);
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            S.push(slow);
        }
        if (fast.next == null) S.pop();

        slow = slow.next;
        while (slow != null) {
            if (!slow.getData().equals(((ListNode)S.pop()).getData())) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    // Use only O(1) space
    public boolean isPalindrome3() {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        boolean jump = fast.next == null;
        ListNode nextStart = slow.next;
        slow.next = null;

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        if (jump) pre = pre.next;

        while (nextStart != null && pre != null) {
            if (!nextStart.getData().equals(pre.getData())) {
                return false;
            }
            nextStart = nextStart.next;
            pre = pre.next;
        }
        if (pre != null || nextStart != null)
            return false;
        return true;
    }

    /**
     * Odd Even Linked List
     *
     * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
     *
     * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
     *
     * Example:
     * Given 1->2->3->4->5->NULL,
     *         return 1->3->5->2->4->NULL.
     *
     *         Note:
     * The relative order inside both the even and odd groups should remain as it was in the input.
     * The first node is considered odd, the second node even and so on ...
     */
    public ListNode oddEvenList() {
        if (head == null) return head;
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        if (len <= 2) return head;
        ListNode end = cur;

        ListNode pre = head;
        cur = head.next;
        int handled = 1;
        while (handled < len) {
            handled++;
            if (handled % 2 == 0) {
                pre.next = cur.next;
                cur.next = null;
                end.next = cur;
                end = cur;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
    public ListNode oddEvenList2() {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode preOdd = head;
        ListNode headEven = head.next;
        ListNode preEven = head.next;
        ListNode cur = head.next.next;
        preOdd.next = null;
        preEven.next = null;

        boolean odd = true;
        while (cur != null) {
            ListNode next = cur.next;
            if (odd) {
                preOdd.next = cur;
                preOdd = cur;
            } else {
                preEven.next = cur;
                preEven = cur;
            }
            cur.next = null;
            cur = next;
            odd = !odd;
        }
        preOdd.next = headEven;

        return head;
    }

    /**
     * Add Two Numbers II
     * You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Follow up:
     * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
     * Example:
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     */
    public ListNodeInt addTwoNumbers(ListNodeInt l1, ListNodeInt l2) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        Stack res = new Stack();
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carry + (s1.isEmpty()?0:(int)s1.peek()) + (s2.isEmpty()?0:(int)s2.peek());
            if (!s1.isEmpty()) s1.pop();
            if (!s2.isEmpty()) s2.pop();

            res.push(sum%10);
            carry = sum/10;
        }
        if (carry != 0) {
            res.push(carry);
        }

        ListNodeInt tempHead = new ListNodeInt(0);
        ListNodeInt pre = tempHead;
        while (!res.isEmpty()) {
            ListNodeInt newNode = new ListNodeInt((int)res.pop());
            pre.next = newNode;
            pre = newNode;
        }
        return tempHead.next;
    }

    /**
     * Determine if a linked list contains a circle. If it does, return the start point for the circle
     */
    public static void circleStartDemo(ListNodeInt head, Integer r) {
        System.out.println("\nStart function circleStartDemo()");
        System.out.println("\tCircleStart = " + r);
        ListNodeInt circleStart = circleStart(head);
        System.out.println("\tStart of circle: " + circleStart.val);
    }
    public static ListNodeInt circleStart(ListNodeInt head) {
        if (head == null || head.next == null) return null;
        ListNodeInt slow = head;
        ListNodeInt fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == null || fast == null || slow != fast) {
            return null;
        }
        ListNodeInt iter = head;
        while (iter != slow) {
            iter = iter.next;
            slow = slow.next;
        }
        return iter;
    }

    /**
     * Plus One Linked List
     *
     * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
     *
     * The digits are stored such that the most significant digit is at the head of the list.
     *
     *         Example:
     * Input:
     *         1->2->3
     *
     * Output:
     *         1->2->4
     */
    public static ListNodeInt plusOne(ListNodeInt head) {
        ListNodeInt firstNotNine = null;
        ListNodeInt cur = head;

        while (cur != null) {
            if (cur.val != 9) {
                firstNotNine = cur;
            }
            cur = cur.next;
        }

        if (firstNotNine == null) {
            ListNodeInt newHead = new ListNodeInt(0);
            newHead.next = head;
            head = newHead;
            firstNotNine = newHead;
        }
        firstNotNine.val = firstNotNine.val + 1;
        cur = firstNotNine.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        return head;
    }
}
