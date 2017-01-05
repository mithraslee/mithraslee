/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.node;

/**
 *
 * @author yunl
 */
public class TreeNode<T extends Number> extends Node<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    
    public TreeNode (T d) {
        this (d, null, null);
    }
    public TreeNode (T d, TreeNode l, TreeNode r) {
        super (d);
        left = l;
        right = r;
    }
}
