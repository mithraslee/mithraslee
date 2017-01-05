/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.stack;

/**
 *
 * @author yunl
 */
public class QueueBySingleStack<T extends Number> {
    public StackTest<T> stack;
    
    public QueueBySingleStack () {
        stack = new StackTest<T> ();
    }
    
    public int length () {
        return stack.size();
    }
    public boolean isEmpty () {
        return stack.isEmpty();
    }
    public void enqueue (T val) {
        stack.push(val);
    }
    public T dequeue () {
        if (isEmpty()) {
            return null;
        }
        T top = stack.pop();
        if (isEmpty()) {
            return top;
        } else {
            T result = dequeue ();
            enqueue(top);
            return result;
        }
    }
    public T end () {
        return stack.top.getData();
    }
    public T front () {
        if (isEmpty()) {
            return null;
        }
        T top = stack.pop();
        if (isEmpty()) {
            enqueue(top);
            return top;
        } else {
            T result = front ();
            enqueue(top);
            return result;
        }
    }
}
