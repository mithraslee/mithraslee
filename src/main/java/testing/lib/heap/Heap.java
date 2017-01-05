/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.heap;

import java.util.*;

/**
 *
 * @author yunl
 */
public abstract class Heap <T extends Number> {
    public ArrayList<T> arr;
    public Comparator<T> comparator;
    
    public Heap () {
        arr = new ArrayList<> ();
    }
    public Heap (Collection<T> col) {
        this ();
        arr.addAll(col);
    }
    
    public Integer parent (Integer i) {
        if (i == 0)
            return -1;
        else
            return (i - 1)/2;
    }
    public Integer left (Integer i) {
        return 2 * i + 1;
    }
    public Integer right (Integer i) {
        return 2 * i + 2;
    }
    private void swap (int i1, int i2) {
        T temp = arr.get(i1);
        arr.set(i1, arr.get(i2));
        arr.set(i2, temp);
    }
    public int size () {
        return arr.size();
    }
    
    public void heapify (Integer i) {
        int left = left(i);
        int right = right(i);
        
        int max = -1;
        
        if (left > (size() - 1)) {
            return;
        } else if (right > (size() - 1)) {
            max = left;
        } else {
            max = (comparator.compare(arr.get(left), arr.get(right)) > 0) ? left : right;
        }
        
        if ((max != -1) &&
            (comparator.compare(arr.get(i), arr.get(max)) < 0)) {
            swap (i, max);
            heapify (max);
        }
    }
    
    public void buildHeap () {
        int len = size()/2;
        for (int i = len; i >= 0; i--) {
            heapify (i);
        }
    }
    
    public T extract () {
        if (size() <= 0)
            return null;
        T val = arr.get(0);
        swap (0, size() - 1);
        arr.remove(size() - 1);
        heapify (0);
        
        return val;
    }
    
    public void changeKey (int i, T val) {
        if (comparator.compare(arr.get(i), val) > 0)
            return;
        arr.set(i, val);
        rollToTop(i);
    }
    
    public void insertHeap (T val) {
        arr.add(val);
        int i = arr.size() - 1;
        rollToTop(i);
    }

    private void rollToTop (int index) {
        if (index <= 0) return;
        while (index >= 0 && parent(index) >= 0 &&
                comparator.compare(arr.get(parent(index)), arr.get(index)) < 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    @Override
    public String toString () {
        return arr.toString();
    }
}
