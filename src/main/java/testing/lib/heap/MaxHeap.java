/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.heap;

import java.util.*;

/**
 *
 * @author yunl
 * @param <T>
 */
public class MaxHeap <T extends Number> extends Heap<T> {
    public MaxHeap () {
        super();
        comparator = (T t1, T t2) -> Double.compare(t1.doubleValue(), t2.doubleValue());
//         comparator = new Comparator<T>() {
//             @Override
//             public int compare(T t1, T t2) {
//                 return Double.compare(t1.doubleValue(), t2.doubleValue());
//             }
//         };
    }
    public MaxHeap (Collection<T> col) {
        super(col);
        comparator = (t1, t2) -> Double.compare(t1.doubleValue(), t2.doubleValue());
//         comparator = new Comparator<T>() {
//             @Override
//             public int compare(T t1, T t2) {
//                 return Double.compare(t1.doubleValue(), t2.doubleValue());
//             }
//         };
    }
}
