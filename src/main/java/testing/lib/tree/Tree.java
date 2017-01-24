/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.tree;

import java.util.*;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;
import testing.lib.node.*;

import javax.sound.midi.Sequence;

/**
 *
 * @author yunl
 */
public class Tree <T extends Number> {
    public TreeNode<T> root;

    public Tree() {
        root = null;
    }

    public TreeIterator<T> iterator() {
        return new TreeIterator<>(root);
    }

    public List<T> inorder() {
        TreeNode<T> cur = root;
        Stack<TreeNode> s = new Stack<>();
        List<T> l = new ArrayList<>();

        while (true) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            if (!s.isEmpty()) {
                cur = s.pop();
                l.add(cur.getData());
                cur = cur.right;
            } else
                break;
        }
        return l;
    }

    public List<T> preorder() {
        TreeNode<T> cur = root;
        Stack<TreeNode> s = new Stack<>();
        List<T> l = new ArrayList<>();

        while (true) {
            while (cur != null) {
                s.push(cur);
                l.add(cur.getData());
                cur = cur.left;
            }
            if (!s.isEmpty()) {
                cur = s.pop();
                cur = cur.right;
            } else
                break;
        }
        return l;
    }

    public List<T> postorder() {
        TreeNode<T> cur = root;
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> sr = new Stack<>();
        List<T> l = new ArrayList<>();

        while (true) {
            while (cur != null) {
                s.push(cur);
                sr.push(cur);
                cur = cur.right;
            }
            if (!s.isEmpty()) {
                cur = s.pop();
                cur = cur.left;
            } else
                break;
        }
        while (!sr.isEmpty()) {
            l.add((T) sr.pop().getData());
        }
        return l;
    }

    public void insert(T d) {
        TreeNode<T> newNode = new TreeNode<>(d);
        TreeNode<T> cur = root;
        TreeNode<T> parent = null;

        while (cur != null) {
            if (cur.compareTo(d) == 0) {
                return;
            } else if (cur.compareTo(d) > 0) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (parent == null) {
            root = newNode;
        } else {
            if (parent.compareTo(newNode) > 0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }

    public void insertRecursive(T d) {
        root = insertRecursiveHelper(root, d);
    }

    private TreeNode<T> insertRecursiveHelper(TreeNode<T> n, T d) {
        if (n == null) {
            return new TreeNode<T>(d);
        } else {
            if (n.compareTo(d) == 0)
                return n;
            else if (n.compareTo(d) > 0) {
                n.left = insertRecursiveHelper(n.left, d);
            } else {
                n.right = insertRecursiveHelper(n.right, d);
            }
        }
        return n;
    }

    public boolean delete(T d) {
        TreeNode<T> cur = root;
        TreeNode<T> par = null;

        while (cur != null) {
            if (cur.compareTo(d) == 0) {
                break;
            } else if (cur.compareTo(d) > 0) {
                par = cur;
                cur = cur.left;
            } else {
                par = cur;
                cur = cur.right;
            }
        }
        if (cur == null) return false;
        if (cur.left == null && cur.right == null) {
            if (par == null) root = null;
            else if (par.left == cur) par.left = null;
            else par.right = null;
        } else if (cur.left == null) {
            if (par == null) root = cur.right;
            else if (par.left == cur) par.left = cur.right;
            else par.right = cur.right;
        } else if (cur.right == null) {
            if (par == null) root = cur.left;
            else if (par.left == cur) par.left = cur.left;
            else par.right = cur.left;
        } else {
            TreeNode<T> rPar = cur;
            TreeNode<T> rLeftMost = cur.right;
            while (rLeftMost.left != null) {
                rPar = rLeftMost;
                rLeftMost = rLeftMost.left;
            }
            cur.setData(rLeftMost.getData());
            if (cur == rPar) {
                cur.right = rLeftMost.right;
            } else {
                rPar.left = rLeftMost.right;
            }
        }
        return true;
    }

    public void deleteRecursive(T d) {
        root = deleteRecursiveHelper(d, root);
    }

    private TreeNode<T> deleteRecursiveHelper(T d, TreeNode<T> cur) {
        if (cur == null) return null;
        if (cur.compareTo(d) > 0) {
            cur.left = deleteRecursiveHelper(d, cur.left);
        } else if (cur.compareTo(d) < 0) {
            cur.right = deleteRecursiveHelper(d, cur.right);
        } else {
            if (cur.left == null && cur.right == null) {
                cur = null; // return null;
            } else if (cur.left == null) {
                cur = cur.right; //return cur.right;
            } else if (cur.right == null) {
                cur = cur.left; //return cur.left;
            } else {
                TreeNode<T> rLeftMost = leftMostNode(cur.right);
                cur.setData(rLeftMost.getData());
                cur.right = deleteRecursiveHelper(rLeftMost.getData(), cur.right);
            }
        }
        return cur;
    }

    private TreeNode<T> leftMostNode(TreeNode<T> n) {
        if (n == null) return null;
        while (n.left != null) n = n.left;
        return n;
    }

    public boolean search(T d) {
        TreeNode<T> cur = root;

        while (cur != null) {
            if (cur.compareTo(d) == 0)
                return true;
            else if (cur.compareTo(d) > 0)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return false;
    }

    public boolean searchRecursive(T d) {
        return searchRecursiveHelper(root, d);
    }

    private boolean searchRecursiveHelper(TreeNode<T> n, T d) {
        if (n != null)
            return false;
        if (n.compareTo(d) == 0)
            return true;
        else if (n.compareTo(d) > 0)
            return searchRecursiveHelper(n.left, d);
        else
            return searchRecursiveHelper(n.right, d);
    }

    public int countLeaves() {
        return countLeavesHelper(root);
    }

    private int countLeavesHelper(TreeNode<T> n) {
        if (n == null)
            return 0;
        else
            return 1 + countLeavesHelper(n.left) + countLeavesHelper(n.right);
    }

    public int maxDepth() {
        return maxDepthHelper(root);
    }

    private int maxDepthHelper(TreeNode<T> n) {
        if (n == null)
            return 0;
        else
            return 1 + Math.max(maxDepthHelper(n.left), maxDepthHelper(n.right));
    }

    public int minDepth() {
        return minDepthHelper(root);
    }

    private int minDepthHelper(TreeNode<T> n) {
        if (n == null)
            return 0;
        else
            return 1 + Math.min(minDepthHelper(n.left), minDepthHelper(n.right));
    }

    public void printTreeHorizontal() {
        System.out.println("Print tree horizontally");
        printTreeHorizontalHelper(root, 0);
    }

    private static void printTreeHorizontalHelper(TreeNode n, int count) {
        if (n == null)
            return;
        printTreeHorizontalHelper(n.right, count + 1);

        int i = count;
        while (i-- > 0)
            System.out.print("\t");
        System.out.println(n.getData());

        printTreeHorizontalHelper(n.left, count + 1);
    }

    public static void printTreeHorizontalStatic(TreeNode node) {
        printTreeHorizontalHelper(node, 0);
    }

    public void printTreeVertical() {
        System.out.println("Print tree vertically");
        List<T> inorderList = inorder();
        HashMap<T, Integer> map = new HashMap<>();
        for (int i = 0; i < inorderList.size(); i++) {
            map.put(inorderList.get(i), i);
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int size = Q.size();
            int printed = 0;
            while (size-- > 0) {
                TreeNode cur = Q.poll();
                Number val = cur.getData();
                int order = map.get(val);
                for (int i = 0; i < order - printed; i++) {
                    System.out.print("\t");
                }
                printed = order;
                System.out.print(val);
                if (cur.left != null)
                    Q.add(cur.left);
                if (cur.right != null)
                    Q.add(cur.right);
            }
            System.out.println();
        }
    }
//    public void printTreeVertical () {
//        System.out.println("Print tree vertically");
//        List<T> inorderList = inorder ();
//
//        TreeNode<T> cur;
//        Queue<TreeNode> q = new LinkedList <> ();
//        if (root != null)
//            q.add(root);
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            int printedTabs = 0;
//
//            while (size-- > 0) {
//                cur = q.poll();
//                int order = 0;
//                for (; order < inorderList.size(); order++) {
//                    if (cur.compareTo(inorderList.get(order)) == 0)
//                        break;
//                }
//                if (order == inorderList.size())
//                    return;
//
//                for (int j = 0; j < (order - printedTabs); j++) {
//                    System.out.print ("\t");
//                }
//                System.out.print(cur.getData());
//                printedTabs = order;
//
//                if (cur.left != null)
//                    q.add(cur.left);
//                if (cur.right != null)
//                    q.add(cur.right);
//            }
//            System.out.println();
//        }
//    }

    // Similar to printTreeVertical()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        List<T> inorderList = inorder();

        TreeNode<T> cur;
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int printedTabs = 0;

            while (size-- > 0) {
                cur = q.poll();
                int order = 0;
                for (; order < inorderList.size(); order++) {
                    if (cur.compareTo(inorderList.get(order)) == 0)
                        break;
                }
                if (order == inorderList.size())
                    return "Error! Cannot find " + cur.getData();

                for (int j = 0; j < (order - printedTabs); j++) {
                    sb.append("\t");
                }
                sb.append(cur.getData());
                printedTabs = order;

                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean printNodeAtLevel(int level) {
        boolean flag = printNodeAtLevelHelper(root, level);
        System.out.println();
        return flag;
    }

    private boolean printNodeAtLevelHelper(TreeNode<T> n, int level) {
        if (n == null || level < 0)
            return false;
        if (level == 0) {
            System.out.print(n.getData() + "\t");
            return true;
        }

        boolean flag = printNodeAtLevelHelper(n.left, level - 1);
        flag |= printNodeAtLevelHelper(n.right, level - 1);
        return flag;
    }

    public void printNodeByLevel() {
        int level = 0;
        while (printNodeAtLevel(level++)) {
        }
    }
    
    /* Populating Next Right Pointers in Each Node II
     * Given a binary tree
     *     struct TreeLinkNode {
     *       TreeLinkNode *left;
     *       TreeLinkNode *right;
     *       TreeLinkNode *next;
     *     }
     * Populate each next pointer to point to its next right node. 
     * If there is no next right node, the next pointer should be set to NULL.
     * Initially, all next pointers are set to NULL.
     * Note:
     *     • You may only use constant extra space.
     *     • You may assume that it is a perfect binary tree 
     *       (ie, all leaves are at the same level, and every parent has two children).
     * For example,
     * Given the following perfect binary tree,
     *          1
     *        /  \
     *       2    3
     *      / \  / \
     *     4  5  6  7
     * After calling your function, the tree should look like:
     *          1 -> NULL
     *        /  \
     *       2 -> 3 -> NULL
     *      / \  / \
     *     4->5->6->7 -> NULL
     */


    /* Follow up for problem "Populating Next Right Pointers in Each Node".
     * What if the given tree could be any binary tree? Would your previous solution still work?
     * Note:
     *     • You may only use constant extra space.
     * For example,
     * Given the following binary tree,
     *          1
     *        /  \
     *       2    3
     *      / \    \
     *     4   5    7
     * After calling your function, the tree should look like:
     *          1 -> NULL
     *        /  \
     *       2 -> 3 -> NULL
     *      / \    \
     *     4-> 5 -> 7 -> NULL
     *
     * http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
     */
    public void connect(TreeNodeWithNext<T> n) {
        TreeNodeWithNext<T> cur = n;
        if (cur != null) {
            TreeNodeWithNext<T> nextLevelStart = null;
            TreeNodeWithNext<T> nextLevelPre = null;

            while (cur != null) {
                if (nextLevelStart == null) {
                    nextLevelStart = cur.left == null ? cur.right : cur.left;
                }
                if (cur.left != null)
                    if (nextLevelPre != null) {
                        nextLevelPre.next = cur.left;
                        nextLevelPre = cur.left;
                    }
                if (cur.right != null)
                    if (nextLevelPre != null) {
                        nextLevelPre.next = cur.right;
                        nextLevelPre = cur.right;
                    }
                if (cur.next == null) {
                    cur = nextLevelStart;
                    nextLevelStart = null;      // Important!
                    nextLevelPre = null;
                } else
                    cur = cur.next;
            }
        }
    }

    // This version might be more readable?
    public void connect2(TreeNodeWithNext<T> n) {
        TreeNodeWithNext<T> cur = n;
        while (cur != null) {       // Handle one level every time entering while loop
            TreeNodeWithNext<T> nextLevelStart = null;
            TreeNodeWithNext<T> nextLevelPre = null;

            for (; cur != null; cur = cur.next) {
                if (nextLevelStart == null) {
                    nextLevelStart = cur.left == null ? cur.right : cur.left;
                }
                if (cur.left != null) {
                    if (nextLevelPre != null)
                        nextLevelPre.next = cur.left;
                    nextLevelPre = cur.left;
                }
                if (cur.right != null) {
                    if (nextLevelPre != null)
                        nextLevelPre.next = cur.right;
                    nextLevelPre = cur.right;
                }
            }
            cur = nextLevelStart;
        }
    }

    public Tree<T> rebuildFromInorderAndPreorder() {
        Tree<T> td = new Tree<T>();

        td.root = rebuildFromInorderAndPreorderHelper(inorder(), preorder());

        return td;
    }

    private TreeNode<T> rebuildFromInorderAndPreorderHelper(List<T> inorder, List<T> preorder) {
        if (inorder == null || preorder == null || inorder.isEmpty() || preorder.isEmpty() || inorder.size() != preorder.size())
            return null;

        // System.out.println("inorder: " + inorder);
        // System.out.println("preorder: " + preorder);

        int len = inorder.size();

        TreeNode<T> newNode = new TreeNode<>(preorder.get(0));

        if (len != 1) {
            int leftLen = 0;
            for (; leftLen < len; leftLen++) {
                if (newNode.compareTo(inorder.get(leftLen)) == 0)
                    break;
            }
            if (leftLen == len)
                return null;

            newNode.left = rebuildFromInorderAndPreorderHelper(inorder.subList(0, leftLen), preorder.subList(1, leftLen + 1));
            newNode.right = rebuildFromInorderAndPreorderHelper(inorder.subList(leftLen + 1, len), preorder.subList(leftLen + 1, len));
        }
        return newNode;
    }

    public boolean equalTo(Tree<T> tr) {
        return equalToHelper(root, tr.root);
    }

    private boolean equalToHelper(TreeNode<T> n1, TreeNode<T> n2) {
        if (n1 == null && n2 == null)
            return true;
        else if (n1 == null || n2 == null)
            return false;
        else {
            if (n1.compareTo(n2) != 0)
                return false;
            else {
                return equalToHelper(n1.left, n2.left) && equalToHelper(n1.right, n2.right);
            }
        }
    }

    public Tree<T> mirrorCopy() {
        Tree<T> mirrorTree = new Tree<>();
        mirrorTree.root = mirrorCopyHelper(root);
        return mirrorTree;
    }

    private TreeNode<T> mirrorCopyHelper(TreeNode<T> n) {
        if (n == null)
            return null;

        TreeNode<T> newNode = new TreeNode<>(n.getData());

        newNode.left = mirrorCopyHelper(n.right);
        newNode.right = mirrorCopyHelper(n.left);

        return newNode;
    }

    /*
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * 
     * For example, this binary tree is symmetric:
     * 
     *      1
     *     / \
     *    2   2
     *   / \ / \
     *  3  4 4  3
     * But the following is not:
     *      1
     *     / \
     *    2   2
     *     \   \
     *     3    3
     */
    public boolean isSymmetricRecursive() {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode<T> n1, TreeNode<T> n2) {
        if (n1 == null && n2 == null)
            return true;
        else if ((n1 == null) || (n2 == null) || (n1.compareTo(n2) != 0))
            return false;
        else
            return isSymmetricHelper(n1.left, n2.right) &&
                    isSymmetricHelper(n1.right, n2.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;
        Queue queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque dq = new ArrayDeque();

            while (size-- > 0) {
                TreeNode cur = (TreeNode) queue.poll();
                if (cur != null) {
                    if (cur.left != null)
                        queue.add(cur.left);
                    else
                        queue.add(null);

                    if (cur.right != null)
                        queue.add(cur.right);
                    else
                        queue.add(null);
                } else {
                    dq.addLast(0);
                }
            }
            if (dq.size() == 1) {
                if ((dq.size() % 2) == 1)
                    return false;
                while (!dq.isEmpty()) {
                    Integer first = (Integer) dq.removeFirst();
                    Integer last = (Integer) dq.removeLast();
                    if (first != last)
                        return false;
                }
            }
        }
        return true;
    }

    /* Two nodes of a BST are switched positions. Recover the BST */
    public void recoverTree() {
        TreeNode<T> cur = root;
        Stack s = new Stack();
        TreeNode<T> pre = null;
        TreeNode<T> first = null;
        TreeNode<T> second = null;

        while (true) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            if (!s.isEmpty()) {
                cur = (TreeNode<T>) s.pop();
                if (pre != null) {
                    if (pre.compareTo(cur) > 0) {
                        if (first == null) {
                            first = pre;
                            second = cur;       // This line is important !!! Attention !!!
                        } else
                            second = cur;
                    }
                }
                pre = cur;
                cur = cur.right;
            } else
                break;
        }
        if (first != null && second != null) {
            T temp = first.getData();
            first.setData(second.getData());
            second.setData(temp);
        }
    }

    public T ithElement(int ith) {
        int count = countLeaves();
        if (count < ith) {
            System.out.println(count + " < " + ith);
            return null;
        }

        TreeNode<T> cur = root;
        Stack<TreeNode> s = new Stack<>();
        int kth = 0;

        while (true) {
            while (cur != null) {
                s.add(cur);
                cur = cur.left;
            }
            if (!s.isEmpty()) {
                cur = s.pop();
                kth++;
                if (kth == ith) {
                    return cur.getData();
                }
                cur = cur.right;
            } else
                return null;
        }
    }

    public T ithElementRecursive(int ith) {
        int count = countLeaves();
        if (count < ith) {
            System.out.println(count + " < " + ith);
            return null;
        }

        int[] var = new int[]{0, ith};
        return ithElementRecursiveHelper(root, var);
    }

    private T ithElementRecursiveHelper(TreeNode<T> n, int[] var) {
        if (n != null) {
            T val = ithElementRecursiveHelper(n.left, var);

            if (val != null)
                return val;

            var[0]++;
            if (var[0] == var[1]) {
                return n.getData();
            }

            return ithElementRecursiveHelper(n.right, var);
        }
        return null;
    }

    public T getLCA(T a, T b) {
        if (Double.compare(a.doubleValue(), b.doubleValue()) > 0) {
            return getLCA(b, a);
        }
        if (!search(a) || !search(b)) {
            System.out.println(a + " or " + b + " cannot be found.");
            return null;
        }

        TreeNode<T> cur = root;
        while ((cur.compareTo(a) <= 0) || (cur.compareTo(b) >= 0)) {
            if (cur.compareTo(a) == 0 || cur.compareTo(b) == 0) {
                return cur.getData();
            } else if (cur.compareTo(a) < 0) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return cur.getData();
    }

    // Better version
    public T getLCA2(T a, T b) {
        if (Double.compare(a.doubleValue(), b.doubleValue()) > 0) {
            return getLCA(b, a);
        }
        if (!search(a) || !search(b)) {
            System.out.println(a + " or " + b + " cannot be found.");
            return null;
        }

        TreeNode<T> cur = root;
        while (cur != null) {
            if (cur.compareTo(a) < 0) {
                cur = cur.right;
            } else if (cur.compareTo(b) > 0) {
                cur = cur.left;
            } else {
                return cur.getData();
            }
        }
        return null;
    }

    public boolean isBST() {
        if (root == null)
            return true;
        TreeNode<T> cur = root;
        TreeNode<T> last = null;
        Stack<TreeNode> s = new Stack<>();

        while (true) {
            while (cur != null) {
                s.add(cur);
                cur = cur.left;
            }
            if (!s.isEmpty()) {
                cur = s.pop();
                if (last != null) {
                    if (last.compareTo(cur) > 0)
                        return false;
                }
                last = cur;
                cur = cur.right;
            } else {
                break;
            }
        }
        return true;
    }
    // This version is wrong!!!
//    public boolean isBSTRecursive() {
//        return isBSTRecursiveHelper(root);
//    }
//
//    private boolean isBSTRecursiveHelper(TreeNode<T> n) {
//        if (n == null)
//            return true;
//
//        Double curVal = n.getData().doubleValue();
//        Double leftVal = (n.left != null) ? n.left.getData().doubleValue() : Double.NEGATIVE_INFINITY;
//        Double rightVal = (n.right != null) ? n.right.getData().doubleValue() : Double.POSITIVE_INFINITY;
//
//        if (curVal < leftVal || curVal > rightVal)
//            return false;
//        else
//            return isBSTRecursiveHelper(n.left) && isBSTRecursiveHelper(n.right);
//    }
    public boolean isBSTRecursive(TreeNodeInt root) {
        return isBSTRecursiveHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isBSTRecursiveHelper(TreeNodeInt node, long leftPre, long rightPre) {
        if (node == null) return true;
        if ((long)node.val <= leftPre || (long)node.val >= rightPre) return false;
        if (node.left != null && node.left.val >= node.val) return false;
        if (node.right != null && node.right.val <= node.val) return false;

        return isBSTRecursiveHelper(node.left, leftPre, (long)node.val) &&
                isBSTRecursiveHelper(node.right, (long)node.val, rightPre);
    }


    public void printPath() {
        System.out.println("\nStart function printPath()");
        printPathHelper(root, new ArrayList<T>(), 0);
    }

    private void printPathHelper(TreeNode<T> n, List<T> list, int level) {
        if (n == null)
            return;
        if (list.size() <= level)
            list.add(n.getData());
        else
            list.set(level, n.getData());

        if ((n.left == null) && (n.right == null)) {
            System.out.println("\t" + list.subList(0, level + 1));
        } else {
            printPathHelper(n.left, list, level + 1);
            printPathHelper(n.right, list, level + 1);
        }
    }

    // Optimal solution
    public void printPath2() {
        System.out.println("\nStart function printPath2()");
        printPathHelper2(root, new LinkedList<>());
    }

    private void printPathHelper2(TreeNode<T> cur, LinkedList<T> tmp) {
        if (cur == null) return;
        tmp.add(cur.getData());
        if (cur.left == null && cur.right == null) {
            System.out.println("\t" + tmp);
        } else {
            printPathHelper2(cur.left, tmp);
            printPathHelper2(cur.right, tmp);
        }
        tmp.removeLast(); // This line is very important !!! Attention !!!
    }

    public TreeNode<T> getParent(TreeNode<T> n) {
        return getParent(n.getData());
    }

    public TreeNode<T> getParent(T val) {
        TreeNode<T> parent = null;
        TreeNode<T> cur = root;

        while (cur != null) {
            if (cur.compareTo(val) == 0)
                return parent;
            else if (cur.compareTo(val) > 0) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        return null;
    }

    /* Tree rotation
     *      pre                        pre
     *       |        left rotate       |
     *       x      =============>      y
     *      / \                        / \
     *     a   y    <=============    x   c
     *        / \    right rotate    / \
     *       b   c                  a   b
     */
    public void leftRotate(T x) {
        if (search(x) == false) {
            System.out.println("Cannot find " + x + " for left-rotation");
            return;
        }

        TreeNode<T> parent = getParent(x);
        TreeNode<T> xNode;
        if (parent == null) {
            xNode = root;
        } else {
            xNode = (parent.compareTo(x) > 0) ? parent.left : parent.right;
        }

        if (xNode.right == null) {
            System.out.println("Cannot find the right child of " + x + " for left-rotation");
            return;
        }

        TreeNode<T> yNode = xNode.right;
        xNode.right = yNode.left;

        if (parent == null)
            root = yNode;
        else {
            if (parent.left == xNode)
                parent.left = yNode;
            else
                parent.right = yNode;
        }

        yNode.left = xNode;
    }

    /*
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     * Find the total sum of all root-to-leaf numbers.
     * For example, 
     *     1
     *    / \
     *   2   3
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13. 
     * Return the sum = 12 + 13 = 25. 
     */
    public Integer SumRoottoLeafNumbers() {
        HashSet<Integer> num = new HashSet<>();
        int temp = 0;
        SumRoottoLeafNumbersHelper((TreeNode<Integer>) root, temp, num);

        System.out.println("SumRoottoLeafNumbers: " + num);
        Integer sum = 0;
        for (Integer i : num) {
            sum += i;
        }
        return sum;
    }

    private void SumRoottoLeafNumbersHelper(TreeNode<Integer> node, Integer temp, HashSet<Integer> num) {
        if (node == null)
            return;
        temp *= 10;
        temp += node.getData();
        if (node.left == null && node.right == null) {
            num.add(temp);
        } else {
            SumRoottoLeafNumbersHelper(node.left, temp, num);
            SumRoottoLeafNumbersHelper(node.right, temp, num);
        }
    }

    /**
     * Given n, generate all structurally unique BST's (binary search trees) that
     * store values 1...n.
     * For example,
     * Given n = 3, your program should return all 5 unique BST's shown below.
     * 1         3     3      2      1
     *  \       /     /      / \      \
     *   3     2     1      1   3      2
     *  /     /       \                 \
     * 2     1         2                 3
     */
    public static ArrayList<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }

    // Optimal solution
    public static ArrayList<TreeNode> generateTreesHelper(int begin, int end) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        if (begin == end) {
            arr.add(new TreeNode(begin));
        } else if (begin > 0 && begin < end) {
            for (int cur = begin; cur <= end; cur++) {
                ArrayList<TreeNode> leftArrs = generateTreesHelper(begin, cur - 1);
                ArrayList<TreeNode> rightArrs = generateTreesHelper(cur + 1, end);
                if (leftArrs.isEmpty()) {
                    for (TreeNode node : rightArrs) {
                        TreeNode newRoot = new TreeNode(cur);
                        newRoot.right = (TreeNode) node;
                        newRoot.left = null;
                        arr.add(newRoot);
                    }
                } else if (rightArrs.isEmpty()) {
                    for (TreeNode node : leftArrs) {
                        TreeNode newRoot = new TreeNode(cur);
                        newRoot.left = node;
                        newRoot.right = null;
                        arr.add(newRoot);
                    }
                } else {
                    for (TreeNode lNode : leftArrs) {
                        for (TreeNode rNode : rightArrs) {
                            TreeNode newRoot = new TreeNode(cur);
                            newRoot.left = lNode;
                            newRoot.right = rNode;
                            arr.add(newRoot);
                        }
                    }
                }
            }
        }
        return arr;
    }

    public static ArrayList<TreeNode> generateTreesHelper2(int begin, int end) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        if (begin <= 0 || begin > end) {
            arr.add(null);
        } else if (begin == end) {
            arr.add(new TreeNode(begin));
        } else {
            for (int cur = begin; cur <= end; cur++) {
                ArrayList<TreeNode> leftArrs = generateTreesHelper2(begin, cur - 1);
                ArrayList<TreeNode> rightArrs = generateTreesHelper2(cur + 1, end);
                if (leftArrs.isEmpty()) {
                    ArrayList<TreeNode> tempArr = (ArrayList<TreeNode>) rightArrs.clone();
                    for (TreeNode node : rightArrs) {
                        TreeNode newRoot = new TreeNode(cur);
                        // Need to make a clone of node here 
                        newRoot.right = (TreeNode) node;
                        newRoot.left = null;
                        arr.add(newRoot);
                    }
                } else if (rightArrs.isEmpty()) {
                    ArrayList<TreeNode> tempArr = (ArrayList<TreeNode>) leftArrs.clone();
                    for (TreeNode node : leftArrs) {
                        TreeNode newRoot = new TreeNode(cur);
                        // Need to make a clone of node here 
                        newRoot.left = node;
                        newRoot.right = null;
                        arr.add(newRoot);
                    }
                } else {
                    ArrayList<TreeNode> tempLeftArr = (ArrayList<TreeNode>) leftArrs.clone();
                    ArrayList<TreeNode> tempRightArr = (ArrayList<TreeNode>) rightArrs.clone();
                    for (TreeNode lNode : leftArrs) {
                        for (TreeNode rNode : rightArrs) {
                            TreeNode newRoot = new TreeNode(cur);
                            // Need to make a clone of lNode, rNode here 
                            newRoot.left = lNode;
                            newRoot.right = rNode;
                            arr.add(newRoot);
                        }
                    }
                }
            }
        }
        return arr;
    }

    /**
     * House Robber III
     * <p>
     * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
     * Besides the root, each house has one and only one parent house.
     * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
     * It will automatically contact the police if two directly-linked houses were broken into on the same night.
     * <p>
     * Determine the maximum amount of money the thief can rob tonight without alerting the police.
     * <p>
     * Example 1:
     *   3
     *  / \
     * 2   3
     *  \   \
     *   3   1
     * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     * Example 2:
     *     3
     *    / \
     *   4   5
     *  / \   \
     * 1   3   1
     * Maximum amount of money the thief can rob = 4 + 5 = 9.
     */
    private static class Sum {
        int withCurrent;
        int noCurrent;

        public Sum(int w, int n) {
            withCurrent = w;
            noCurrent = n;
        }
    }

    public static int rob(TreeNodeInt root) {
        if (root == null) return 0;

        Sum res = robHelper(root);

        return Math.max(res.withCurrent, res.noCurrent);
    }

    private static Sum robHelper(TreeNodeInt node) {
        if (node == null) return new Sum(0, 0);
        if (node.left == null && node.right == null) return new Sum(node.val, 0);

        Sum leftVal = robHelper(node.left);
        Sum rightVal = robHelper(node.right);

        return new Sum(node.val + leftVal.noCurrent + rightVal.noCurrent,
                Math.max(leftVal.withCurrent, leftVal.noCurrent) + Math.max(rightVal.withCurrent, rightVal.noCurrent));
    }
    public static int rob2(TreeNodeInt root) {
        if (root == null) return 0;

        int[] res = robHelper2(root);

        return Math.max(res[0], res[1]);
    }

    private static int[] robHelper2(TreeNodeInt node) {
        if (node == null) return new int[]{0, 0};
        if (node.left == null && node.right == null) return new int[]{node.val, 0};

        int[] leftVal = robHelper2(node.left);
        int[] rightVal = robHelper2(node.right);

        return new int[]{node.val + leftVal[1] + rightVal[1],
                Math.max(leftVal[0], leftVal[1]) + Math.max(rightVal[0], rightVal[1])};
    }

    /**
     * Binary Tree Paths
     * Given a binary tree, return all root-to-leaf paths.
     * <p>
     * For example, given the following binary tree:
     * <p>
     *     1
     *   /   \
     *  2     3
     *   \
     *    5
     * All root-to-leaf paths are:
     * <p>
     * ["1->2->5", "1->3"]
     */
    public static List<String> binaryTreePaths(TreeNodeInt root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        binaryTreePathsHelper(root, "", res);
        return res;
    }

    private static void binaryTreePathsHelper(TreeNodeInt node, String temp, List<String> res) {
        String newStr = temp.isEmpty() ? "" + node.val : temp + "->" + node.val;

        if (node.left == null && node.right == null) {
            res.add(newStr);
            return;
        }

        if (node.left != null)
            binaryTreePathsHelper(node.left, newStr, res);
        if (node.right != null)
            binaryTreePathsHelper(node.right, newStr, res);
    }

    /**
     * Serialize and Deserialize Binary Tree
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     * <p>
     * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
     * <p>
     * For example, you may serialize the following tree
     * <p>
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
     * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            TreeNode cur = Q.poll();

            if (cur == null) {
                sb.append("null,");
            } else {
                sb.append(cur.getData() + ",");
                Q.add(cur.left);
                Q.add(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] vals = data.split(",");
        int[] nums = new int[vals.length];
        TreeNode[] nodes = new TreeNode[vals.length];

        for (int i = 0; i < vals.length; i++) {
            if (i > 0) {
                nums[i] = nums[i - 1];
            }
            if (vals[i].equals("null")) {
                nums[i]++;
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
            }
        }

        for (int i = 0; i < vals.length; i++) {
            if (nodes[i] == null) continue;
            nodes[i].left = nodes[2 * (i - nums[i]) + 1];
            nodes[i].right = nodes[2 * (i - nums[i]) + 2];
        }

        return nodes[0];
    }

    /**
     * Serialize and Deserialize BST
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     * <p>
     * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
     * <p>
     * The encoded string should be as compact as possible.
     * <p>
     * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
     */
    public String serializeBST(TreeNode root) {
        String inorder = inorder(root);
        String preorder = preorder(root);
        return inorder + ";" + preorder;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeBST(String data) {
        String[] inorderArr = data.split(";")[0].split(",");
        String[] preorderArr = data.split(";")[1].split(",");

        List<String> inorder = new ArrayList<>(Arrays.asList(inorderArr));
        List<String> preorder = new ArrayList<>(Arrays.asList(preorderArr));

        return rebuild(inorder, preorder);
    }

    private TreeNode rebuild(List<String> inorder, List<String> preorder) {
        assert inorder.size() == preorder.size();
        int len = inorder.size();
        if (len == 0) return null;
        TreeNode newNode = new TreeNode(Integer.parseInt(preorder.get(0)));
        if (len > 1) {
            int leftLen = 0;
            for (; leftLen < len; leftLen++) {
                if (inorder.get(leftLen).equals(preorder.get(0))) {
                    break;
                }
            }
            newNode.left = rebuild(inorder.subList(0, leftLen), preorder.subList(1, leftLen + 1));
            newNode.right = rebuild(inorder.subList(leftLen + 1, len), preorder.subList(leftLen + 1, len));
        }
        return newNode;
    }

    private String inorder(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Stack S = new Stack();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                S.push(cur);
                cur = cur.left;
            }
            if (!S.isEmpty()) {
                cur = (TreeNode) S.pop();
                if (sb.length() == 0) {
                    sb.append(cur.getData());
                } else {
                    sb.append(",").append(cur.getData());
                }
                cur = cur.right;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    private String preorder(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Stack S = new Stack();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                if (sb.length() == 0) {
                    sb.append(cur.getData());
                } else {
                    sb.append(",").append(cur.getData());
                }
                S.push(cur);
                cur = cur.left;
            }
            if (!S.isEmpty()) {
                cur = (TreeNode) S.pop();
                cur = cur.right;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    /**
     * Sum of Left Leaves
     * Find the sum of all left leaves in a given binary tree.
     * Example:
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     */
    public static int sumOfLeftLeaves(TreeNodeInt root) {
        if (root == null) return 0;

        ArrayList<Integer> lefts = new ArrayList<>();
        helper(root, false, lefts);
        int t = 0;
        for (int i : lefts) t += i;
        return t;
    }

    public static void helper(TreeNodeInt node, Boolean left, ArrayList<Integer> lefts) {
        if (node == null) return;
        if ((node.left == null) && (node.right == null) && left) {
            lefts.add(node.val);
        } else {
            helper(node.left, true, lefts);
            helper(node.right, false, lefts);
        }
    }

    /**
     * Path Sum III
     * You are given a binary tree in which each node contains an integer value.
     * Find the number of paths that sum to a given value.
     * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
     * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     * Example:
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     * Return 3. The paths that sum to 8 are:
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3. -3 -> 11
     */
    static int total = 0;

    public static int pathSum(TreeNodeInt root, int sum) {
        total = 0;
        if (root != null) {
            pathSumHelper(root, sum, new LinkedList<Integer>());
        }
        return total;
    }

    private static void pathSumHelper(TreeNodeInt root, int sum, LinkedList<Integer> pres) {
        if (root != null) {
            int s = root.val;
            if (s == sum) {
                // This is easy to be missed
                total++;
            }
            ListIterator<Integer> iter = pres.listIterator();
            while (iter.hasNext()) {
                s += iter.next();
                if (s == sum) {
                    total++;
                }
            }
            pres.addFirst(root.val);
            pathSumHelper(root.left, sum, pres);
            pathSumHelper(root.right, sum, pres);
            pres.removeFirst();
        }
    }

    /**
     * Binary Tree Upside Down
     * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
     * For example:
     * Given a binary tree {1,2,3,4,5},
     *     1
     *    / \
     *   2   3
     *  / \
     * 4   5
     * return the root of the binary tree [4,5,2,#,#,3,1].
     *   4
     *  / \
     * 5   2
     *    / \
     *   3   1
     */
    // Passed
    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return newRoot;
    }
    // Passed
    public static TreeNode upsideDownBinaryTreeRecursive(TreeNode root) {
        TreeNode pre = null;
        TreeNode cur = root;
        TreeNode newLeft = null;

        while (cur != null) {
            TreeNode next = cur.left;
            cur.left = newLeft;
            newLeft = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * Find Leaves of Binary Tree
     * Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.
     * Example:
     * Given binary tree 
     *     1
     *    / \
     *   2   3
     *  / \
     * 4   5
     * Returns [4, 5, 3], [2], [1].
     * Explanation:
     * 1. Remove the leaves [4, 5, 3] from the tree
     * 1
     * /
     * 2
     * 2. Remove the leaf [2] from the tree
     * 1
     * 3. Remove the leaf [1] from the tree
     * []
     * Returns [4, 5, 3], [2], [1].
     */
    public static List<List<Integer>> findLeaves(TreeNodeInt root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            ArrayList<Integer> tmp = new ArrayList<>();
            root = findLeavesHelper(root, tmp);
            res.add(tmp);
        }
        return res;
    }
    private static TreeNodeInt findLeavesHelper(TreeNodeInt node, ArrayList<Integer> tmp) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            tmp.add(node.val);
            return null;
        }
        node.left = findLeavesHelper(node.left, tmp);
        node.right = findLeavesHelper(node.right, tmp);
        return node;
    }

    /**
     * Largest BST Subtree
     * <p>
     * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
     * <p>
     * Note:
     * A subtree must include all of its descendants.
     * Here's an example:
     * <p>
     *     10
     *    /  \
     *   5   15
     *  / \    \
     * 1   8    7
     * The Largest BST Subtree in this case is the highlighted one.
     * The return value is the subtree's size, which is 3.
     * <p>
     * Hint:
     * <p>
     * You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
     * Follow up:
     * Can you figure out ways to solve it with O(n) time complexity?
     */
    // Passed
    private static class TreeNodeStatus {
        boolean isBST;
        int smallest;
        int largest;
        int count;

        public TreeNodeStatus() {
            isBST = true;
            smallest = Integer.MAX_VALUE;
            largest = Integer.MIN_VALUE;
            count = 0;
        }
    }
    public static int largestBSTSubtree(TreeNodeInt root) {
        System.out.println("\nStart function largestBSTSubtree()");
        printTreeVertical(root);

        if (root == null) {
            return 0;
        }

        List<Integer> res = new ArrayList<>();
        largestBSTSubtreeHelper(root, res);
        int max = Integer.MIN_VALUE;
        for (int r : res) {
            max = Math.max(max, r);
        }
        System.out.println("\t" + res);
        System.out.println("\tlargestBSTSubtree size = " + max);
        return max;
    }
    private static TreeNodeStatus largestBSTSubtreeHelper(TreeNodeInt node, List<Integer> res) {
        TreeNodeStatus tmp = new TreeNodeStatus();
        if (node.left == null && node.right == null) {
            tmp.isBST = true;
            tmp.smallest = node.val;
            tmp.largest = node.val;
            tmp.count = 1;
        } else if (node.left == null) {
            TreeNodeStatus right = largestBSTSubtreeHelper(node.right, res);
            if (right.isBST && node.val < right.smallest) {
                tmp.isBST = true;
                tmp.smallest = node.val;
                tmp.largest = right.largest;
                tmp.count = right.count + 1;
            } else {
                tmp.isBST = false;
            }
        } else if (node.right == null) {
            TreeNodeStatus left = largestBSTSubtreeHelper(node.left, res);
            if (left.isBST && node.val > left.largest) {
                tmp.isBST = true;
                tmp.smallest = left.smallest;
                tmp.largest = node.val;
                tmp.count = left.count + 1;
            } else {
                tmp.isBST = false;
            }
        } else {
            TreeNodeStatus left = largestBSTSubtreeHelper(node.left, res);
            TreeNodeStatus right = largestBSTSubtreeHelper(node.right, res);
            if (left.isBST && right.isBST && node.val > left.largest && node.val < right.smallest) {
                tmp.isBST = true;
                tmp.smallest = left.smallest;
                tmp.largest = right.largest;
                tmp.count = left.count + right.count + 1;
            } else {
                tmp.isBST = false;
            }
        }
        if (tmp.isBST) {
            res.add(tmp.count);
        }
        return tmp;
    }

    public static int largestBSTSubtree2(TreeNodeInt root) {
        System.out.println("\nStart function largestBSTSubtree2()");
        printTreeVertical(root);

        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        largestBSTSubtreeDFS2(root, res);

        System.out.println("\tlargestBSTSubtree size = " + res.get(0));
        return res.get(0);
    }
    private static void largestBSTSubtreeDFS2(TreeNodeInt node, ArrayList<Integer> res) {
        if (node == null) return;
        int d = countBstBFS(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (d > 0) {
            res.set(0, Math.max(res.get(0), d));
            return;
        }
        largestBSTSubtreeDFS2(node.left, res);
        largestBSTSubtreeDFS2(node.right, res);
    }
    private static int countBstBFS(TreeNodeInt node, int mn, int mx) {
        if (node == null) return 0;
        if (node.val <= mn || node.val >= mx) return -1;
        int leftCnt = countBstBFS(node.left, mn, node.val);
        if (leftCnt == -1) {
            return -1;
        }
        int rightCnt = countBstBFS(node.right, node.val, mx);
        if (rightCnt == -1) {
            return -1;
        }
        return leftCnt + rightCnt + 1;
    }


    public static void printTreeVertical(TreeNodeInt root) {
        System.out.println("Print tree vertically");
        List<Integer> inorder = new ArrayList<>();
        TreeNodeInt cur = root;
        Stack<TreeNodeInt> S = new Stack<>();
        while (true) {
            while (cur != null) {
                S.push(cur);
                cur = cur.left;
            }
            if (!S.isEmpty()) {
                cur = S.pop();
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                break;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }
        Queue<TreeNodeInt> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int size = Q.size();
            int printed = 0;
            while (size-- > 0) {
                cur = Q.poll();
                Integer val = cur.val;
                int order = map.get(val);
                for (int i = 0; i < order - printed; i++) {
                    System.out.print("\t");
                }
                printed = order;
                System.out.print(val);
                if (cur.left != null)
                    Q.add(cur.left);
                if (cur.right != null)
                    Q.add(cur.right);
            }
            System.out.println();
        }
        System.out.println("\tInorder: " + inorder);
    }

    /**
     * Binary Tree Vertical Order Traversal
     * <p>
     * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
     * <p>
     * If two nodes are in the same row and column, the order should be from left to right.
     * <p>
     * Examples:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its vertical order traversal as:
     * [
     * [9],
     * [3,15],
     * [20],
     * [7]
     * ]
     * Given binary tree [3,9,20,4,5,2,7],
     *     _3_
     *    /   \
     *   9    20
     *  / \   / \
     * 4   5 2   7
     * return its vertical order traversal as:
     * [
     * [4],
     * [9],
     * [3,5,2],
     * [20],
     * [7]
     * ]
     * Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     *      3
     *     /\
     *    /  \
     *    9   8
     *   /\  /\
     *  /  \/  \
     *  4  01   7
     *     /\
     *    /  \
     *    5   2
     * return its vertical order traversal as:
     * [
     * [4],
     * [9,5],
     * [3,0,1],
     * [8,2],
     * [7]
     * ]
     */
    public static class NodeVerticalOrder {
        int order;
        TreeNodeInt node;

        public NodeVerticalOrder(int o, TreeNodeInt t) {
            order = o;
            node = t;
        }
    }
    // Passed
    public static List<List<Integer>> verticalOrder(TreeNodeInt root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
        Queue<NodeVerticalOrder> Q = new LinkedList<>();
        Q.add(new NodeVerticalOrder(0, root));
        while (!Q.isEmpty()) {
            NodeVerticalOrder cur = Q.poll();
            if (map.containsKey(cur.order)) {
                map.get(cur.order).add(cur.node.val);
            } else {
                LinkedList<Integer> newList = new LinkedList<>();
                newList.add(cur.node.val);
                map.put(cur.order, newList);
            }
            if (cur.node.left != null) {
                Q.add(new NodeVerticalOrder(cur.order - 1, cur.node.left));
            }
            if (cur.node.right != null) {
                Q.add(new NodeVerticalOrder(cur.order + 1, cur.node.right));
            }
        }

        for (int o : map.keySet()) {
            res.add(map.get(o));
        }

        return res;
    }
    // This version's output order would be wrong
    public List<List<Integer>> verticalOrder2(TreeNodeInt root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
        verticalOrder(root, 0, map);
        for (int level : map.keySet()) {
            res.add(map.get(level));
        }
        return res;
    }
    private void verticalOrder(TreeNodeInt node, int level, TreeMap<Integer, LinkedList<Integer>> map) {
        if (node == null) {
            return;
        }
        if (map.containsKey(level)) {
            map.get(level).add(node.val);
        } else {
            LinkedList<Integer> tmpList = new LinkedList<>();
            tmpList.add(node.val);
            map.put(level, tmpList);
        }
        verticalOrder(node.left, level - 1, map);
        verticalOrder(node.right, level + 1, map);
    }

    /**
     * Binary Tree Longest Consecutive Sequence
     * <p>
     * Given a binary tree, find the length of the longest consecutive sequence path.
     * <p>
     * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
     * <p>
     * For example,
     *      1
     *       \
     *        3
     *       / \
     *      2   4
     *           \
     *            5
     * Longest consecutive sequence path is 3-4-5, so return 3.
     *      2
     *       \
     *        3
     *       /
     *      2
     *     /
     *    1
     * Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
     */
    public static int longestConsecutive(TreeNodeInt root) {
        if (root == null) return 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        longestConsecutiveDFS(root, root.val - 1, 1, res);
        int max = 0;
        for (int i : res) {
            max = Math.max(max, i);
        }
        return max;
    }

    private static void longestConsecutiveDFS(TreeNodeInt node, int lastVal, int curLen, ArrayList<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.val == lastVal + 1) {
            curLen++;
        } else {
            curLen = 1;
        }
        res.add(curLen);
        longestConsecutiveDFS(node.left, node.val, curLen, res);
        longestConsecutiveDFS(node.right, node.val, curLen, res);
    }

    /**
     * Count Univalue Subtrees
     *
     * Given a binary tree, count the number of uni-value subtrees.
     * A Uni-value subtree means all nodes of the subtree have the same value.
     * For example:
     *
     * Given binary tree,
     *     5
     *    / \
     *   1   5
     *  / \   \
     * 5   5   5
     * return 4.
     */
    private static int univalSubtreesCount;
    public static int countUnivalSubtrees(TreeNodeInt root) {
        univalSubtreesCount = 0;
        countUnivalSubtreesDFS(root);
        return univalSubtreesCount;
    }
    private static boolean countUnivalSubtreesDFS(TreeNodeInt root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            univalSubtreesCount++;
            return true;
        }
        if (root.right == null) {
            if (countUnivalSubtreesDFS(root.left) && root.val == root.left.val) {
                univalSubtreesCount++;
                return true;
            } else {
                return false;
            }
        }
        if (root.left == null) {
            if (countUnivalSubtreesDFS(root.right) && root.val == root.right.val) {
                univalSubtreesCount++;
                return true;
            } else {
                return false;
            }
        }
        if (countUnivalSubtreesDFS(root.right) &&
            countUnivalSubtreesDFS(root.left) &&
            root.val == root.left.val &&
            root.val == root.right.val) {
            univalSubtreesCount++;
            return true;
        } else {
            return false;
        }
    }
    // Better version. Harder to follow
    public static int countUnivalSubtrees2(TreeNodeInt root) {
        univalSubtreesCount = 0;
        countUnivalSubtreesDFS2(root, -1);
        return univalSubtreesCount;
    }
    private static boolean countUnivalSubtreesDFS2(TreeNodeInt root, Integer val) {
        if (root == null) {
            return true;
        }
        // This version is wrong. Since it might lead to right subtree not been processed
//        if (!countUnivalSubtreesDFS2(root.left, root.val) || !countUnivalSubtreesDFS2(root.right, root.val)) {
//            return false;
//        }
        boolean left = !countUnivalSubtreesDFS2(root.left, root.val);
        boolean right = !countUnivalSubtreesDFS2(root.right, root.val);
        if (left || right) {
            return false;
        }
        univalSubtreesCount++;
        return root.val == val;
    }
    // Similar version as countUnivalSubtrees(). Simpler with class SubTreeStatus
    private static class SubTreeStatus {
        boolean isUnival;
        Integer val;
        public SubTreeStatus(boolean isUni, Integer v) {
            isUnival = isUni;
            val = v;
        }
    }
    public static int countUnivalSubtrees3(TreeNodeInt root) {
        univalSubtreesCount = 0;
        countUnivalSubtreesDFS3(root);
        return univalSubtreesCount;
    }
    private static SubTreeStatus countUnivalSubtreesDFS3(TreeNodeInt root) {
        if (root == null) {
            return new SubTreeStatus(true, null);
        }
        SubTreeStatus left = countUnivalSubtreesDFS3(root.left);
        SubTreeStatus right = countUnivalSubtreesDFS3(root.right);
        if ((left.isUnival && (left.val == null || left.val == root.val)) &&
            (right.isUnival && (right.val == null || right.val == root.val))) {
            univalSubtreesCount++;
            return new SubTreeStatus(true, root.val);
        } else {
            return new SubTreeStatus(false, root.val);
        }
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = 1;
        TreeNode tmp = root.left;
        while (tmp != null) {
            left++;
            tmp = tmp.left;
        }
        int right = 1;
        tmp = root.right;
        while (tmp != null) {
            right++;
            tmp = tmp.right;
        }
        if (left == right) {
            return (int)Math.pow(2, left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    /**
     * Closest Binary Search Tree Value
     * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
     *
     *         Note:
     * Given target value is a floating point.
     * You are guaranteed to have only one unique value in the BST that is closest to the target.
     */
    public int closestValue(TreeNodeInt root, double target) {
        Stack<TreeNodeInt> S = new Stack<>();
        TreeNodeInt cur = root;

        int smallest = 0;
        double diff = Double.MAX_VALUE;
        while (true) {
            while (cur != null) {
                S.push(cur);
                cur = cur.left;
            }
            if (S.isEmpty()) {
                break;
            } else {
                cur = S.pop();
                if (diff > Math.abs((double)cur.val - target)) {
                    diff = Math.abs((double)cur.val - target);
                    smallest = cur.val;
                }
                if (diff == 0.0) {
                    break;
                }
                cur = cur.right;
            }
        }
        return smallest;
    }

    /**
     * Closest Binary Search Tree Value II
     * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
     *
     *         Note:
     * Given target value is a floating point.
     * You may assume k is always valid, that is: k ≤ total nodes.
     * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
     * Follow up:
     * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
     */
    public List<Integer> closestKValues(TreeNodeInt root, double target, int k) {
        Stack<TreeNodeInt> S = new Stack<>();
        TreeNodeInt cur = root;

        PriorityQueue<Pair<Double, Integer>> Q = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        while (true) {
            while (cur != null) {
                S.push(cur);
                cur = cur.left;
            }
            if (S.isEmpty()) {
                break;
            } else {
                cur = S.pop();
                Q.add(new Pair<>(Math.abs((double)cur.val - target), cur.val));
                if (Q.size() > k) {
                    Q.poll();
                }
                cur = cur.right;
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (Pair<Double, Integer> p : Q) {
            res.add(p.getValue());
        }
        return res;
    }

    /**
     * Verify Preorder Sequence in Binary Search Tree
     * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
     * You may assume each number in the sequence is unique.
     * Follow up:
     * Could you do it using only constant space complexity?
     */
    public static boolean verifyPreorder(int[] preorder) {
        int len = preorder.length;
        if (len <= 2) return true;

        return verifyPreorder(preorder, 0, len - 1);
    }
    private static boolean verifyPreorder(int[] preorder, int left, int right) {
        if (right - left + 1 <= 2) return true;
        if (left > right) return true;
        int first = preorder[left];

        int cut = left + 1;
        while (cut <= right && preorder[cut] < first) {
            cut++;
        }
        for (int i = cut; i <= right; i++) {
            if (preorder[i] <= first) {
                return false;
            }
        }
        return verifyPreorder(preorder, left + 1, cut - 1) && verifyPreorder(preorder, cut, right);
    }
}