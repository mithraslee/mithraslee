/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.stack;

import testing.lib.node.*;

/**
 *
 * @author yunl
 */
public class StackTest<T extends Number> {
    public ListNode<T> top;
    
    public StackTest () {
        top = null;
    }
    public StackTest (T val) {
        this (new ListNode<T> (val));
    }
    public StackTest (ListNode<T> n) {
        top = n;
    }
    
    public boolean isEmpty () {
        return (top == null);
    }
    public int size () {
        ListNode<T> cur = top;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
    public T top () {
        if (this.isEmpty())
            return null;
        else 
            return top.getData();
    }
    public T pop () {
        if (this.isEmpty())
            return null;
        else {
            T topVal = top.getData();
            top = top.next;
            return topVal;
        }
    }
    public void push (T val) {
        ListNode<T> newNode = new ListNode<> (val, top);
        top = newNode;
    }
    
    public void sortStack () {
        StackTest<T> tmp = new StackTest<> ();
        
        while (!this.isEmpty()) {
            T cur = this.pop();
            
            while ((!tmp.isEmpty()) && (tmp.top.compareTo(cur) > 0)) {
                this.push(tmp.pop());
            }
            tmp.push(cur);
        }
//        System.out.println("tmp: \n" + tmp);
        while (!tmp.isEmpty()) {
            this.push(tmp.pop());
        }
    }
    
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder ();
        
        ListNode<T> cur = top;
        int size = this.size();
        
        sb.append("     ");
        for (int i = 0; i < size; i++) {
            sb.append("====");
        }
        sb.append("\nTOP : ");
        
        while (cur != null) {
            if (cur.next != null)
                sb.append(cur.getData().toString() + " | ");
            else
                sb.append(cur.getData().toString() + " |");
            cur = cur.next;
        }
        sb.append("\n     ");
        
        for (int i = 0; i < size; i++) {
            sb.append("====");
        }
        
        return sb.toString();
    }
}
