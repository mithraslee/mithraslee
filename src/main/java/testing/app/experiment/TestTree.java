package testing.app.experiment;

import testing.lib.node.TreeNode;
import testing.lib.node.TreeNodeInt;
import testing.lib.tree.Tree;
import testing.lib.tree.TreeIterator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestTree {
    public static void run() {
        int size = 10;
        Tree<Integer> ti1 = new Tree<> ();
        for (int i = 0; i < size; i++) {
            ti1.insert((int)(Math.random() * size + 1));
        }
        ti1.printTreeHorizontal();

        Tree<Integer> ti2 = new Tree<> ();
        for (int i = 0; i < size; i++) {
            ti2.insertRecursive((int)(Math.random() * size + 1));
        }
        ti2.printTreeHorizontal();

        ti2.printTreeVertical();

        System.out.println("preorder walk:" + ti2.preorder());
        System.out.println("inorder walk:" + ti2.inorder());
        System.out.println("postorder walk:" + ti2.postorder());
//        int level0 = 0;
//        int level1 = 1;
        int level2 = 2;
//        System.out.println("Level(" + level0 + "): " + ti2.printNodeAtLevel(level0));
//        System.out.println("Level(" + level1 + "): " + ti2.printNodeAtLevel(level1));
        System.out.println("Level(" + level2 + "): " + ti2.printNodeAtLevel(level2));
        System.out.println("printNodeByLevel: ");
        ti2.printNodeByLevel();

        System.out.println("Print ti2 directly");
        System.out.println(ti2);

        Tree<Integer> ti2d = ti2.rebuildFromInorderAndPreorder();
        System.out.println("Print rebuilt tree");
        System.out.println(ti2d);
        System.out.println("ti2 == ti2d: " + ti2.equalTo(ti2d));
        System.out.println("Leaves count of ti2 : " + ti2.countLeaves());

        Tree<Integer> ti2mirror = ti2.mirrorCopy();
        System.out.println("Print mirror tree");
        System.out.println(ti2mirror);

        System.out.println("The 3rd element of ti2 is: " + ti2.ithElement(3));
        System.out.println("The 5th element of ti2 is: " + ti2.ithElementRecursive(5));

        int i1 = (int)(Math.random() * size + 1);
        int i2 = (int)(Math.random() * size + 1);
        System.out.println("The LCA of " + i1 + " and " + i2 + " in ti2 is " + ti2.getLCA(i1, i2));
        System.out.println("The LCA of " + i1 + " and " + i2 + " in ti2 is " + ti2.getLCA2(i1, i2));

        System.out.println("ti2 is BST: " + ti2.isBST());
        System.out.println("ti2mirror is BST: " + ti2mirror.isBST());
        System.out.println("ti2 is BST: " + ti2.isBSTRecursive());
        System.out.println("ti2mirror is BST: " + ti2mirror.isBSTRecursive());

        System.out.println("Max depth of ti2 is " + ti2.maxDepth());
        System.out.println("Min depth of ti2 is " + ti2.minDepth());

        ti2.printPath();
        ti2.printPath2();

        System.out.println("Parent of 4 is " + ((ti2.getParent(4) == null)? null : ti2.getParent(4).getData()));
        System.out.println("Left rotate ti2 at 4");
        ti2.leftRotate(4);
        System.out.println(ti2);

        System.out.println(ti1);
        Integer sum = ti1.SumRoottoLeafNumbers();
        System.out.println("Sum of Root to Leaf Numbers:" + sum);

        Tree<Integer> ti3 = new Tree<> ();
        ti3.insert(1);
//        for (int i = 0; i < size; i++) {
//            ti2.insertRecursive((int)(Math.random() * size + 1));
//        }
        ti3.printTreeHorizontal();
        System.out.println("ti3 is symmetric: " + ti3.isSymmetricIterative(ti3.root));

        Deque dq1 = new ArrayDeque();
        Deque dq2 = new ArrayDeque ();
        dq1.addFirst(1);
        dq2.addLast(1);
        dq1.addFirst(2);
        dq2.addLast(2);
        dq1.addFirst(1);
        dq2.addLast(1);
        System.out.println("dq1: " + dq1);
        System.out.println("dq2: " + dq2);
        if (dq1.toArray().equals(dq2.toArray())) {
            System.out.println("dq1 == dq2");
        } else {
            System.out.println("dq1 != dq2");
        }

        ArrayList<TreeNode> arrNode = Tree.generateTrees(3);
        for (TreeNode node : arrNode) {
            System.out.println ("*********");
            Tree.printTreeHorizontalStatic(node);
        }
//        for (Iterator<TreeNode> iter = arrNode.iterator(); iter.hasNext();) {
//            TreeNode node = iter.next();
//            System.out.println ("*********");
//            Tree.printTreeHorizontalStatic(node);
//        }

        int size2 = 8;
        Tree<Integer> ti4 = new Tree<> ();
        for (int i = 0; i < size2; i++) {
            ti4.insert((int)(Math.random() * size + 1));
        }
        ti4.printTreeVertical();
        TreeIterator<Integer> iter = ti4.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().getData());
        }

//        Tree<Integer> ti5 = new Tree<> ();
//        for (int i = 0; i < 10; i++) {
//            ti5.insert((int)(Math.random() * 10 + 1));
//        }
//        System.out.println("\nBefore delete: ");
//        ti5.printTreeVertical();
//        int toDelete = (int)(Math.random() * size + 1);
//        ti5.delete(toDelete);
//        System.out.println("After delete: " + toDelete);
//        ti5.printTreeVertical();

//        Tree<Integer> ti6 = new Tree<> ();
//        Integer[] iarr = new Integer[] {5, 3, 8, 2, 4, 6, 9, 1, 7, 10};
//        for (Integer in : iarr) ti6.insert(in);
//        System.out.println("\nBefore delete: ");
//        ti6.printTreeVertical();
//        for (int i = 1; i <= 10; i++) {
//            Tree<Integer> ti6Dup = new Tree<> ();
//            for (Integer in : iarr) ti6Dup.insert(in);
//
//            ti6Dup.deleteRecursive(i);
//            System.out.println("After delete: " + i);
//            ti6Dup.printTreeVertical();
//        }

        Tree<Integer> ti6 = new Tree<> ();
        Integer[] iarr = new Integer[] {5, 3, 6, 2, 4, 7};
        for (Integer in : iarr) ti6.insert(in);
        System.out.println("\nBefore delete: ");
        ti6.printTreeVertical();

        ti6.deleteRecursive(3);
        System.out.println("After delete: 3");
        ti6.printTreeVertical();
//        for (int i = 1; i <= 10; i++) {
//            Tree<Integer> ti6Dup = new Tree<> ();
//            for (Integer in : iarr) ti6Dup.insert(in);
//
//            ti6Dup.deleteRecursive(i);
//            System.out.println("After delete: " + i);
//            ti6Dup.printTreeVertical();
//        }

        TreeNodeInt root1 = new TreeNodeInt(3);
        root1.left = new TreeNodeInt(4);
        root1.right = new TreeNodeInt(5);
        root1.left.left = new TreeNodeInt(1);
        root1.left.right = new TreeNodeInt(3);
        root1.right.right = new TreeNodeInt(1);
        int maxMoney = Tree.rob(root1);
        System.out.println("\tmaxMoney = " + maxMoney);

        TreeNodeInt root2 = new TreeNodeInt(4);
        root2.left = new TreeNodeInt(1);
        root2.left.left = new TreeNodeInt(2);
        root2.left.left.left = new TreeNodeInt(3);
        System.out.println("\tmaxMoney = " + Tree.rob(root2));

        TreeNodeInt root3 = new TreeNodeInt(1);
        root3.left = new TreeNodeInt(2);
        root3.right = new TreeNodeInt(3);
        root3.left.right = new TreeNodeInt(5);
        List<String> res = Tree.binaryTreePaths(root3);
        for (String s : res) {
            System.out.println("\t" + s);
        }

        TreeNodeInt root4 = new TreeNodeInt(3);
        root4.left = new TreeNodeInt(9);
        root4.right = new TreeNodeInt(20);
        root4.right.left = new TreeNodeInt(15);
        root4.right.right = new TreeNodeInt(7);
        System.out.println(Tree.sumOfLeftLeaves(root4));

        TreeNodeInt root5 = new TreeNodeInt(10);
        root5.left = new TreeNodeInt(5);
        root5.left.left = new TreeNodeInt(3);
        root5.left.left.left = new TreeNodeInt(3);
        root5.left.left.right = new TreeNodeInt(-2);
        root5.left.right = new TreeNodeInt(2);
        root5.left.right.right = new TreeNodeInt(1);
        root5.right = new TreeNodeInt(-3);
        root5.right.right = new TreeNodeInt(11);
//        System.out.println(Tree.pathSum(root5, 8));
        TreeNodeInt root6 = new TreeNodeInt(5);
        root6.left = new TreeNodeInt(4);
        root6.left.left = new TreeNodeInt(11);
        root6.left.left.left = new TreeNodeInt(7);
        root6.left.left.right = new TreeNodeInt(2);
        root6.right = new TreeNodeInt(8);
        root6.right.left = new TreeNodeInt(13);
        root6.right.right = new TreeNodeInt(4);
        root6.right.right.left = new TreeNodeInt(5);
        root6.right.right.right = new TreeNodeInt(1);
        System.out.println(Tree.pathSum(root6, 22));
    }
}
