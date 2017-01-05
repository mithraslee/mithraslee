/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.library;

import java.util.*;

/**
 *
 * @author yunl
 */
public class CloneGraph {
    /*
     * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
     * 
     * OJ's undirected graph serialization:
     * Nodes are labeled uniquely.
     * 
     * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
     * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
     * 
     * The graph has a total of three nodes, and therefore contains three parts as separated by #.
     * 
     * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
     * Second node is labeled as 1. Connect node 1 to node 2.
     * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
     * Visually, the graph looks like the following:
     * 
     *       1
     *      / \
     *     /   \
     *    0 --- 2
     *         / \
     *         \_/
     */
    private static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
        @Override
        public String toString () {
            StringBuilder sb = new StringBuilder();
            sb.append("Node(").append(label).append(") -> <");
            for (UndirectedGraphNode n : neighbors) {
                sb.append(n.label).append("; ");
            }
            sb.append(">");
            return sb.toString();
        }
    };
//    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    public static void cloneGraph() {
        UndirectedGraphNode node0 = new UndirectedGraphNode (0);
        UndirectedGraphNode node1 = new UndirectedGraphNode (1);
        UndirectedGraphNode node2 = new UndirectedGraphNode (2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node1.neighbors.add(node0);
        node2.neighbors.add(node0);
        node2.neighbors.add(node1);
        node2.neighbors.add(node2);
        
        UndirectedGraphNode node = node0;
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList<> ();
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<> ();
        HashSet<Integer> done = new HashSet<> ();
        
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        map.put(newHead.label, newHead);
        
        queue.add(node);
        done.add(node.label);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.peek();
            if (!map.containsKey(curNode.label)) {
                UndirectedGraphNode newNode = new UndirectedGraphNode(curNode.label);
                map.put(curNode.label, newNode);
            }
            UndirectedGraphNode cloneNode = map.get(curNode.label);
            map.remove(curNode.label);
            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                if (!done.contains(neighbor.label) && !queue.contains(neighbor)) {
                    queue.add(neighbor);
                }
                if (!map.containsKey(neighbor.label)) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor.label, newNode);
                }
                cloneNode.neighbors.add(map.get(neighbor.label));
            }
            map.put(cloneNode.label, cloneNode);
            queue.remove();
            done.add(curNode.label);
            System.out.println("Queue size: " + queue.size());
        }
        System.out.println("Node0: " + node0);
        System.out.println("Node0's neighbors: ");
        for (UndirectedGraphNode n : node0.neighbors) {
            System.out.println("\t" + n);
        }
        
        System.out.println("HashMap's size = " + map.size());
        System.out.println("HashSet's size = " + done.size());
        System.out.println("HashMap: " + map);
        
        System.out.println("New head: " + newHead);
        System.out.println("New head's neighbors: ");
        for (UndirectedGraphNode n : newHead.neighbors) {
            System.out.println("\t" + n);
        }
//        return newHead;
    }
}
