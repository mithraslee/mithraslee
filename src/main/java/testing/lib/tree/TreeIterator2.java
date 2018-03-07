package testing.lib.tree;

import testing.lib.node.TreeNode;

import java.util.Stack;

/**
 * Created by Yun on 3/5/2018.
 */
public class TreeIterator2 <T extends Number> {
    public TreeIterator2 (TreeNode<T> root) { enStack(root); }

    public boolean hasNext() {
        return !preStack.isEmpty();
    }

    public TreeNode<T> next() {
        TreeNode<T> cur = preStack.pop();
        enStack(cur.right);
        return cur;
    }

    private void enStack (TreeNode<T> n) {
        while (n != null) {
            preStack.push(n);
            n = n.left;
        }
    }

    private Stack<TreeNode<T>> preStack = new Stack<>();
}
