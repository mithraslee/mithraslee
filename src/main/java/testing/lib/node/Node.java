/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.node;

/**
 *
 * @author yunl
 */
public abstract class Node <T extends Number> implements Comparable<Node> {
    private T data;
    
    public Node (T d) {
        setData (d);
    }
    public T getData () {
        return data;
    }
    public void setData (T t) {
        data = t;
    }
    public int compareTo(Node n) {
        return Double.compare(data.doubleValue(), n.getData().doubleValue());
    }
    public int compareTo(T d) {
        return Double.compare(data.doubleValue(), d.doubleValue());
    }
}
