/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.node;

/**
 *
 * @author yunl
 */
public class DoubleListNode<T extends Number> extends ListNode<T> {
    private DoubleListNode<T> pre;
    public DoubleListNode (T d) {
        this (d, null, null);
    }
    public DoubleListNode (T d, DoubleListNode<T> n, DoubleListNode<T> p) {
        super (d, n);
        setPre (p);
    }
    public DoubleListNode<T> getPre () {
        return pre;
    }
    public void setPre (DoubleListNode<T> n) {
        pre = n;
    }
}
