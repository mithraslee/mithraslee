package testing.app.experiment;

import testing.lib.graph.GraphTest;
import testing.lib.node.GraphNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestGraph {
    public static void run () {
        HashMap<Integer, GraphNode<Integer>> map = new HashMap<> ();
        for (Integer id = 0; id < 5; id++)
            map.put(id, new GraphNode<> (id, id));

        HashMap<GraphNode<Integer>, Integer> neighbor0 = new HashMap<> ();
        neighbor0.put(map.get(1), 10);
        neighbor0.put(map.get(3), 5);
        map.get(0).neighbors.putAll(neighbor0);
        HashMap<GraphNode<Integer>, Integer> neighbor1 = new HashMap<> ();
        neighbor1.put(map.get(2), 1);
        neighbor1.put(map.get(3), 2);
        map.get(1).neighbors.putAll(neighbor1);
        HashMap<GraphNode<Integer>, Integer> neighbor2 = new HashMap<> ();
        neighbor2.put(map.get(4), 4);
        map.get(2).neighbors.putAll(neighbor2);
        HashMap<GraphNode<Integer>, Integer> neighbor3 = new HashMap<> ();
        neighbor3.put(map.get(1), 3);
        neighbor3.put(map.get(2), 9);
        neighbor3.put(map.get(4), 2);
        map.get(3).neighbors.putAll(neighbor3);
        HashMap<GraphNode<Integer>, Integer> neighbor4 = new HashMap<> ();
        neighbor4.put(map.get(0), 7);
        neighbor4.put(map.get(2), 6);
        map.get(4).neighbors.putAll(neighbor4);


        HashSet<GraphNode<Integer>> set = new HashSet<> ();
        for (GraphNode<Integer> nn : map.values())
            set.add(nn);
        GraphTest<Integer> graph = new GraphTest<> (set);
        System.out.println("Graph:\n" + graph);

        List<GraphNode<Integer>> list = graph.Dijkstra(map.get(3));

        System.out.println("After DIJKSTRA:");
        Iterator<GraphNode<Integer>> iter = list.iterator();
        while (iter.hasNext()) {
            GraphNode<Integer> n = iter.next();
            System.out.println("\t" + n.id + " => Distance: " + n.distance);
        }


        int[][] edges = new int[][]{{1,0},{2,0}};
        boolean schedulable = GraphTest.canFinish(3, edges);
        System.out.println(schedulable);

        GraphTest.findItinerary(new String[][]{
                {"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}
        });

        GraphTest.findItinerary(new String[][]{
                {"JFK","A"},{"JFK","C"},{"C","A"},{"A","B"},{"B","JFK"}
        });

//        GraphTest.alienOrderDemo(new String[]{
//                "wrt",
//                "wrf",
//                "er",
//                "ett",
//                "rftt"
//        });

//        GraphTest.alienOrderDemo2(new String[]{
//                "wrtkj","wrt"
//        });
        GraphTest.alienOrderDemo2(new String[]{
                "wrt", "wrtkj"
        });
        char[] buff;
//        GraphTest.alienOrderDemo(new String[]{
//                "zy","zx"
//        });
//
//        GraphTest.alienOrderDemo(new String[]{
//                "x","x"
//        });
    }
}
