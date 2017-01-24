package testing.app.experiment;

import testing.lib.graph.GraphTest;
import testing.lib.node.GraphNode;

import java.util.*;

import static testing.lib.common.CommonUtils.printArray;

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

        int[][] prerequisites = new int[][]{{1,0}};
        int[] order1 = GraphTest.findOrder(2, prerequisites);
        int[] order2 = GraphTest.findOrder2(2, prerequisites);
        printArray(order1, "\tOrder1:");
        printArray(order2, "\tOrder2:");

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

        GraphTest.alienOrderDemo(new String[]{
                "zy","zx"
        });
        GraphTest.alienOrderDemo2(new String[]{
                "zy","zx"
        });
        GraphTest.alienOrderDemo3(new String[]{
                "zy","zx"
        });

        GraphTest.alienOrderDemo(new String[]{
                "wrtkj","wrt"
        });
        GraphTest.alienOrderDemo2(new String[]{
                "wrtkj","wrt"
        });
        GraphTest.alienOrderDemo3(new String[]{
                "wrtkj","wrt"
        });

        GraphTest.alienOrderDemo(new String[]{
                "wrt", "wrtkj"
        });
        GraphTest.alienOrderDemo2(new String[]{
                "wrt", "wrtkj"
        });
        GraphTest.alienOrderDemo3(new String[]{
                "wrt", "wrtkj"
        });

        GraphTest.alienOrderDemo(new String[]{
                "x","x"
        });
        GraphTest.alienOrderDemo2(new String[]{
                "x","x"
        });
        GraphTest.alienOrderDemo3(new String[]{
                "x","x"
        });




        GraphTest.countComponents(5, new int[][]{
                {0, 1}, {1, 2}, {3, 4}
        });
        GraphTest.countComponents(5, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {3, 4}
        });

        GraphTest.validTree2(5, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
        });
        GraphTest.validTree2(5, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}
        });
        GraphTest.validTree2(4, new int[][]{
                {0, 1}, {2, 3}
        });


        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(new Integer[]{5,2,6,3}));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(new Integer[]{4,1,5,2}));
        List<List<Integer>> seqs1 = new ArrayList<>();
        seqs1.add(l1);
        seqs1.add(l2);
        GraphTest.sequenceReconstructionDemo(new int[]{4,1,5,2,6,3}, seqs1);

//        ArrayList<Integer> l3 = new ArrayList<>(Arrays.asList(new Integer[]{1,2}));
//        ArrayList<Integer> l4 = new ArrayList<>(Arrays.asList(new Integer[]{1,3}));
//        ArrayList<Integer> l5 = new ArrayList<>(Arrays.asList(new Integer[]{2,3}));
//        List<List<Integer>> seqs2 = new ArrayList<>();
//        seqs2.add(l3);
//        seqs2.add(l4);
//        seqs2.add(l5);
//        GraphTest.sequenceReconstructionDemo(new int[]{1,2,3}, seqs2);
//
//        List<List<Integer>> seqs3 = new ArrayList<>();
//        seqs3.add(l3);
//        GraphTest.sequenceReconstructionDemo(new int[]{1,2,3}, seqs3);
//
//        List<List<Integer>> seqs4 = new ArrayList<>();
//        seqs4.add(l3);
//        seqs4.add(l4);
//        GraphTest.sequenceReconstructionDemo(new int[]{1,2,3}, seqs4);
//
//        List<List<Integer>> seqs5 = new ArrayList<>();
//        GraphTest.sequenceReconstructionDemo(new int[]{1,2,3}, seqs5);
//        GraphTest.sequenceReconstructionDemo(new int[]{}, seqs5);

//        GraphTest.sequenceReconstructionDemo(new int[]{4,1,5,2,6,3}, new ArrayList<>(
//                Arrays.asList(new List<Integer>[]{
//                        new ArrayList<>(Arrays.asList(new Integer[]{5,2,6,3})),
//                        new ArrayList<>(Arrays.asList(new Integer[]{5,2,6,3}))
//                })
//        ));
    }
}
