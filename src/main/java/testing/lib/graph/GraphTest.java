package testing.lib.graph;

import java.util.Comparator;
import java.util.*;
import java.util.Iterator;
import java.util.PriorityQueue;

import javafx.scene.layout.Priority;
import testing.lib.node.GraphNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yunl
 */
public class GraphTest <T extends Number> {
    public GraphTest (HashSet<GraphNode<T>> n) {
        nodes = n;
    }

    private HashSet<GraphNode<T>> nodes;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<GraphNode<T>> iter = nodes.iterator();
        while (iter.hasNext()) {
            GraphNode<T> n = iter.next();
            sb.append("\t").append(n.toString()).append("\n");
        }
        return sb.toString();
    }

    public List<GraphNode<T>> Dijkstra (GraphNode<T> node) {
        assert nodes.contains(node);
        HashSet<GraphNode<T>> used = new HashSet<> ();
//        HashMap<GraphNode<T>, Boolean> used = new HashMap<> ();
//        for (GraphNode<T> n : nodes) {
//            used.put(n, Boolean.FALSE);
//        }
        
        for (GraphNode<T> n : nodes) {
            n.distance = Integer.MAX_VALUE;
        }
        node.distance = 0;
        
        System.out.println("The start node: " + node);
        
//        PriorityQueue<GraphNode> Q = new PriorityQueue<GraphNode> (nodes.size(), new Comparator<GraphNode> () {
//            @Override
//            public int compare(GraphNode d1, GraphNode d2) {
//                return Integer.compare(d1.distance, d2.distance);
//            }
//        });
        PriorityQueue<GraphNode> Q = new PriorityQueue<>(nodes.size(), (GraphNode d1, GraphNode d2) -> Integer.compare(d1.distance, d2.distance));
        
        LinkedList<GraphNode<T>> res = new LinkedList<> ();
        
        Q.add(node);
        while (!Q.isEmpty()) {
            GraphNode<T> cur = Q.poll();
            res.addLast(cur);
            used.add(cur);

            for (GraphNode<T> n : cur.neighbors.keySet()) {
                if (!used.contains(n)) {
                    n.distance = Math.min(cur.neighbors.get(n) + cur.distance, n.distance);

                    if (Q.contains(n)) {
                        Q.remove(n);
                    }
                    Q.add(n);
                }
            }
        }
        return res;
    }

    /**
     * Course Schedule
     * There are a total of n courses you have to take, labeled from 0 to n - 1.
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
     * For example:
             * 2, [[1,0]]
     * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
             * 2, [[1,0],[0,1]]
     * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
     * Note:
     * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about
     */
//        class Edge {
//            int src;
//            int dest;
//            public Edge(int s, int d) {
//                src = s;
//                dest = d;
//            }
//        }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        int R = prerequisites.length;
        if (R <= 1) return true;
        HashMap<Integer, HashSet<Integer>> DtoS = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> StoD = new HashMap<>();
        ArrayList<Integer> cleanDests = new ArrayList<>();
        HashSet<Integer> cleanDestsSet = new HashSet<>();
        LinkedList<Integer> schedule = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            cleanDestsSet.add(i);
        }
        for(int i = 0; i < R; i++) {
            if (prerequisites[i].length != 2) return false;
            int d = prerequisites[i][0];
            int s = prerequisites[i][1];
            if (DtoS.containsKey(d)) {
                DtoS.get(d).add(s);
            } else {
                HashSet<Integer> srcs = new HashSet<>();
                srcs.add(s);
                DtoS.put(d, srcs);
                cleanDestsSet.remove(d);
            }
            if (StoD.containsKey(s)) {
                StoD.get(s).add(d);
            } else {
                HashSet<Integer> dests = new HashSet<>();
                dests.add(d);
                StoD.put(s, dests);
            }
        }
        cleanDests.addAll(cleanDestsSet);
        while(!cleanDests.isEmpty()) {
            int s = cleanDests.remove(0);
            schedule.addLast(s);
            if (StoD.containsKey(s)) {
                for(int d : StoD.get(s)) {
                    if (DtoS.containsKey(d)) {
                        DtoS.get(d).remove(s);
                        if (DtoS.get(d).isEmpty()) {  // This is important!!!
                            DtoS.remove(d);
                            cleanDests.add(d);
                        }
                    } else {
                        System.out.println("Should never reach this line!");
                        return false;
                    }
                }
                StoD.remove(s);
            }
        }
        if (!DtoS.isEmpty()) return false;
        else return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return new int[]{0};
        int R = prerequisites.length;
        if (R == 0) {
            int[] order = new int[numCourses];
            for(int i = 0; i < numCourses; i++)
                order[i] = i;
            return order;
        }
        HashMap<Integer, HashSet<Integer>> DtoS = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> StoD = new HashMap<>();
        ArrayList<Integer> cleanDests = new ArrayList<>();
        HashSet<Integer> cleanDestsSet = new HashSet<>();
        LinkedList<Integer> schedule = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            cleanDestsSet.add(i);
        }
        for(int i = 0; i < R; i++) {
            if (prerequisites[i].length != 2) return new int[]{};
            int d = prerequisites[i][0];
            int s = prerequisites[i][1];
            if (DtoS.containsKey(d)) {
                DtoS.get(d).add(s);
            } else {
                HashSet<Integer> srcs = new HashSet<>();
                srcs.add(s);
                DtoS.put(d, srcs);
                cleanDestsSet.remove(d);
            }
            if (StoD.containsKey(s)) {
                StoD.get(s).add(d);
            } else {
                HashSet<Integer> dests = new HashSet<>();
                dests.add(d);
                StoD.put(s, dests);
            }
        }
        cleanDests.addAll(cleanDestsSet);
        while(!cleanDests.isEmpty()) {
            int s = cleanDests.remove(0);
            schedule.addLast(s);
            if (StoD.containsKey(s)) {
                for(int d : StoD.get(s)) {
                    if (DtoS.containsKey(d)) {
                        DtoS.get(d).remove(s);
                        if (DtoS.get(d).isEmpty()) {
                            DtoS.remove(d);
                            cleanDests.add(d);
                        }
                    } else {
                        System.out.println("Should never reach this line!");
                        return new int[]{};
                    }
                }
                StoD.remove(s);
            }
        }
        if (!DtoS.isEmpty()) return new int[]{};
        int[] order = new int[schedule.size()];
        int i = 0;
        for(int n : schedule) {
            order[i++] = n;
        }
        return order;
    }

    /**
     * Minimum Height Trees
     *
     * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
     *
     * Format
     * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
     *
     * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
     *
     * Example 1:
     *
     * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
     *
     *         0
     *         |
     *         1
     *        / \
     *       2   3
     *     return [1]
     *
     * Example 2:
     *
     * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     *
     *      0  1  2
     *       \ | /
     *         3
     *         |
     *         4
     *         |
     *         5
     *     return [3, 4]
     *
     * Show Hint
     * Note:
     *
     *         (1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
     *
     *         (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int connLen = edges.length;
        if (connLen < 1) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        HashMap<Integer, HashSet<Integer>> conn = new HashMap<>();
        for (int i = 0; i < connLen; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if (conn.containsKey(n1)) {
                conn.get(n1).add(n2);
            } else {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(n2);
                conn.put(n1, newSet);
            }
            if (conn.containsKey(n2)) {
                conn.get(n2).add(n1);
            } else {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(n1);
                conn.put(n2, newSet);
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        for (Integer i : conn.keySet()) {
            if (conn.get(i).size() == 1) {
                Q.add(i);
            }
        }

        HashMap<Integer, Integer> handledLevel = new HashMap<>();
        HashSet<Integer> lastLevel = new HashSet<>();
        HashSet<Integer> curLevel = new HashSet<>();
        int level = 0;
        while (!Q.isEmpty()) {
            level++;
            curLevel.clear();
            int size = Q.size();
            while (size-- > 0) {
                int i = Q.poll();
                curLevel.add(i);
                handledLevel.put(i, level);
            }

            for (int cur : curLevel) {
                for (int neighbor : conn.get(cur)) {
                    if (!handledLevel.containsKey(neighbor) ||
                        handledLevel.get(neighbor) <= level) {
                        Q.add(neighbor);
                    }
                }
            }
            lastLevel.clear();
            lastLevel.addAll(curLevel);
//            if (!handled.contains(i)) {
//                lastLevel.add(i);
//                handled.add(i);
//                for (int neighbor : conn.get(i)) {
//                    if (!handled.contains(neighbor) && !Q.contains(neighbor)) {
//                        Q.add(neighbor);
//                    }
//                }
//            }
        }
        res.addAll(lastLevel);
        return res;
    }

    /**
     * Reconstruct Itinerary
     * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
     *         Note:
     *         1. If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     *         2. All airports are represented by three capital letters (IATA code).
     *         3. You may assume all tickets form at least one valid itinerary.
     *         Example 1:
     * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
     * Example 2:
     * tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
     * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
     */
    public static List<String> findItinerary(String[][] tickets) {
        System.out.println("\nStart function findItinerary()");
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (map.containsKey(from)) {
                map.get(from).add(to);
            } else {
                map.put(from, new PriorityQueue<String>(Arrays.asList(new String[]{to})));
            }
        }
        assert map.containsKey("JFK") && map.get("JFK").size() > 0;

        LinkedList<String> res = new LinkedList<>();
        findItineraryDFS(map, "JFK", res);
        System.out.println("\t" + res);
        return res;
    }
    private static void findItineraryDFS(HashMap<String, PriorityQueue<String>> map, String start, LinkedList<String> res) {
//        if (res.size() == map.keySet().size()) {
//            return;
//        }
//        if (!map.containsKey(start) || map.get(start).isEmpty()) {
//            return;
//        }
        while(!map.get(start).isEmpty()) {
            String next = map.get(start).poll();
            findItineraryDFS(map, next, res);
        }
        res.addFirst(start);
    }
}
