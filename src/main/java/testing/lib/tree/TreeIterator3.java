package testing.lib.tree;

import testing.lib.node.TreeNode;

import java.util.Stack;

/**
 * Created by yunli on 11/16/15.
 */
public class TreeIterator3 <T extends Number> {
    private Stack<TreeNode<T>> preStack = new Stack<>();
    private TreeNode<T> cur;
    
    public TreeIterator3 (TreeNode<T> root) {
        cur = null;
        enStack(root);
    }

    private void enStack(TreeNode node) {
        while (node != null) {
            preStack.push(node);
            node = node.left;
        }
    }
    private void updateCurNode() {
        if (cur != null) return;

        if (!preStack.isEmpty()) {
            cur = preStack.pop();
            enStack(cur.right);
        }
    }
    public Boolean hasNext() {
        updateCurNode();
        if (cur != null) return true;
        else return false;
    }
    public TreeNode<T> next() {
        TreeNode<T> res = cur;
        cur = null;
        updateCurNode();
        return res;
    }
}
