package testing.lib.node;

/**
 * Created by yun.li on 11/25/16.
 */
public class TreeNodeWithNext<T extends Number> extends Node<T> {
    public TreeNodeWithNext<T> next;
    public TreeNodeWithNext<T> left;
    public TreeNodeWithNext<T> right;

    public TreeNodeWithNext (T d) { this (d, null, null, null); }
    public TreeNodeWithNext (T d, TreeNodeWithNext l, TreeNodeWithNext r, TreeNodeWithNext n) {
        super(d);
        next = n;
        left = l;
        right = r;
    }
}
