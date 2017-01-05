package testing.lib.tree;

import testing.lib.node.TreeNode;

import java.util.Stack;

/**
 * Created by yunli on 11/16/15.
 */
public class TreeIterator <T extends Number> {
    public TreeIterator (TreeNode<T> root) {
        cur = leftMostLeaf(root);
    }

    public Boolean hasNext() {
        return cur != null || !preStack.isEmpty();
    }
    public TreeNode<T> next() {
        if (cur == null)
            return cur;

        TreeNode<T> res = cur;

        if (cur.right == null) {
            if (!preStack.isEmpty())
                cur = preStack.pop();
            else
                cur = null;
        }
        else {
            cur = leftMostLeaf(cur.right);
        }
        return res;
    }

    private TreeNode<T> leftMostLeaf(TreeNode<T> n) {
        if (n == null) return null;
        while (n.left != null) {
            preStack.push(n);
            n = n.left;
        }
        return n;
    }

    private Stack<TreeNode<T>> preStack = new Stack<>();
    private TreeNode<T> cur;
}
