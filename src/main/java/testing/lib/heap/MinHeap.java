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
public class MinHeap <T extends Number> extends Heap<T> {
    public MinHeap () {
        this (null);
    }
    public MinHeap (Collection<T> col) {
        super(col);
        comparator = (T t1, T t2) -> -Double.compare(t1.doubleValue(), t2.doubleValue());
//        comparator = new Comparator<T>() {
//            @Override
//            public int compare(T t1, T t2) {
//                return -Double.compare(t1.doubleValue(), t2.doubleValue());
//            }
//        };
    }
}