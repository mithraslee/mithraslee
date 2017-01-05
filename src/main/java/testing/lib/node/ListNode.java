/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.node;

/**
 *
 * @author yunl
 */
public class ListNode <T extends Number> extends Node<T> {
    public ListNode<T> next;
    public ListNode (T d) {
//        super(d);
//        next = null;
        this(d, null);
    }
    public ListNode (T d, ListNode<T> n) {
        super (d);
        next = n;
    }
//    public ListNode<T> getNext () {
//        return next;
//    }
//    public void setNext (ListNode<T> n) {
//        next = n;
//    }
}
