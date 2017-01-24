package testing.app.experiment;

import testing.lib.library.*;
import testing.lib.library.LFUCache.LFUCache;
import testing.lib.library.LRUCache.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestLibrary {
    public static void run () {
        System.out.println();

        Console c = System.console();

        LRUCache caches = new LRUCache (5);
        caches.set(1, 101);
        caches.set(2, 202);
        caches.set(3, 303);
        caches.set(4, 404);
        caches.set(5, 505);
        System.out.println(caches);

        caches.get(1);
        caches.get(1);
        caches.get(3);
        caches.get(3);
        caches.get(4);
        caches.get(4);
        caches.get(5);
        caches.get(5);
        caches.get(5);
        System.out.println(caches);

        caches.set(6, 606);
        System.out.println(caches);

        caches.get(6);
        caches.get(6);
        caches.get(6);
        System.out.println(caches);
//        c.writer().println(caches);

//        PriorityQueue<Integer> pq = new PriorityQueue<> ();
//        for (int i = 0; i < 10; i++)
//            pq.add((int)(Math.random() * 10));
//
//        System.out.println("PQ: " + pq);
//
//        String login = c.readLine("Input your name: ");
//        char[] pw = c.readPassword("Input your password: ");
//        c.format("Name: " + login);
//        c.format("PW" + pw.toString());


//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(inputStreamReader);
//        System.out.println("Type the line:");
//        try {
//            String line = reader.readLine();
//        } catch (IOException ex) {
//            Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
//        }

        CloneGraph.cloneGraph();

        System.out.println("Testing LRUCache2");
        LRUCache2 lu2 = new LRUCache2(2);
        lu2.set(2, 1);
        System.out.println(lu2);
        lu2.set(2, 2);
        System.out.println(lu2);
        lu2.set(1, 3);
        System.out.println(lu2);
        lu2.set(4, 4);
        System.out.println(lu2);
        int res = lu2.get(2);
        System.out.println(res);

//        System.out.println("Testing LRUCache3");
//        LRUCache3 lu3 = new LRUCache3(2);
//        lu3.set(2, 1);
//        System.out.println(lu3);
//        lu3.set(2, 2);
//        System.out.println(lu3);
//        lu3.set(1, 3);
//        System.out.println(lu3);
//        lu3.set(4, 4);
//        System.out.println(lu3);
//        int res3 = lu3.get(2);
//        System.out.println(res3);

        System.out.println("Testing LRUCache4");
        int res4;
        LRUCache4 lu4 = new LRUCache4(2);
        lu4.set(2, 1);
        System.out.println(lu4);
        lu4.set(1, 3);
        System.out.println(lu4);
        lu4.set(2, 2);
        res4 = lu4.get(2);
        System.out.println(res4);
        System.out.println(lu4);
        lu4.set(4, 4);
        System.out.println(lu4);
        res4 = lu4.get(2);
        System.out.println(res4);

        System.out.println("Testing LRUCache5");
        int res5;
        LRUCache5 lu5 = new LRUCache5(2);
        lu5.set(2, 1);
        System.out.println(lu5);
        lu5.set(1, 3);
        System.out.println(lu5);
        lu5.set(2, 2);
        System.out.println(lu5);
        res5 = lu5.get(2);
        System.out.println(res5);
        lu5.set(4, 4);
        System.out.println(lu5);
        res5 = lu5.get(2);
        System.out.println(res5);

        System.out.println("Testing LRUCache6");
        int res6;
        LRUCache6 lu6 = new LRUCache6(2);
        lu6.set(2, 1);
        System.out.println(lu6);
        lu6.set(1, 3);
        System.out.println(lu6);
        lu6.set(2, 2);
        System.out.println(lu6);
        res6 = lu6.get(2);
        System.out.println(res6);
        lu6.set(4, 4);
        System.out.println(lu6);
        res6 = lu6.get(2);
        System.out.println(res6);

        CalculatorLogic call = new CalculatorLogic("", "");
        boolean calRes = call.getResult(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE);
        System.out.println("calRes = " + calRes);

//        String calInput = "(-2+5)*4/2+1*(9-3*(2+1))-(-1+8/(4-2))";
//        String calInput = "-20+5*(4+12)/2+11";
        String calInput0 = "20+5*11+5";
        System.out.println(calInput0 + " = " + CalculatorNumber.evaluate(calInput0) + " (" + (20+5*11+5) + ")");

        String calInput1 = "-20+5*11+5";
        System.out.println(calInput1 + " = " + CalculatorNumber.evaluate(calInput1) + " (" + (-20+5*11+5) + ")");

        String calInput2 = "(1*(4+5+2)-3)-(6+8)";
        System.out.println(calInput2 + " = " + CalculatorNumber.evaluate(calInput2) + " (" + ((1*(4+5+2)-3)-(6+8)) + ")");

        String calInput3 = "(1+(4+5*2)-3)*(6+8)";
        System.out.println(calInput3 + " = " + CalculatorNumber.evaluate(calInput3) + " (" + ((1+(4+5*2)-3)*(6+8)) + ")");


        LFUCache lru = new LFUCache(2);
        lru.set(1, 1);
        System.out.println(lru);
        lru.set(2, 2);
        System.out.println(lru);
        lru.get(1);       // returns 1
        System.out.println(lru);
        lru.set(3, 3);    // evicts key 2
        System.out.println(lru);
        lru.get(2);       // returns -1 (not found)
        System.out.println(lru);
        lru.get(3);       // returns 3.
        System.out.println(lru);
        lru.set(4, 4);    // evicts key 1.
        System.out.println(lru);
        lru.get(1);       // returns -1 (not found)
        System.out.println(lru);
        lru.get(3);       // returns 3
        System.out.println(lru);
        lru.get(4);       // returns 4
        System.out.println(lru);

        Twitter tw = new Twitter();
        tw.postTweet(1, 5);
        tw.unfollow(1, 1);
        tw.getNewsFeed(1);

        System.out.println("WordDictionary");
        WordDictionary wDict = new WordDictionary();
        wDict.addWord("bad");
        wDict.addWord("dad");
        wDict.addWord("mad");
        System.out.println("\tsearch(\"pad\") = " + wDict.search("pad"));
        System.out.println("\tsearch(\"bad\") = " + wDict.search("bad"));
        System.out.println("\tsearch(\".ad\") = " + wDict.search(".ad"));
        System.out.println("\tsearch(\"b..\") = " + wDict.search("b.."));
        System.out.println("\tsearch(\"\") = " + wDict.search(""));

        System.out.println("\tstartsWith(\"pad\") = " + wDict.startsWith("pad"));
        System.out.println("\tstartsWith(\"bad\") = " + wDict.startsWith("bad"));
        System.out.println("\tstartsWith(\".a.\") = " + wDict.startsWith(".a."));
        System.out.println("\tstartsWith(\".ad\") = " + wDict.startsWith(".ad"));
        System.out.println("\tstartsWith(\".b.\") = " + wDict.startsWith(".b."));
        System.out.println("\tstartsWith(\"b..\") = " + wDict.startsWith("b.."));
        System.out.println("\tstartsWith(\"b.\") = " + wDict.startsWith("b."));
        System.out.println("\tstartsWith(\".\") = " + wDict.startsWith("."));

//        wDict.addWord("a");
//        wDict.addWord("a");
//        wDict.search(".");
//        wDict.search("a");
//        wDict.search("aa");
//        wDict.search("a");
//        wDict.search(".a");
//        System.out.println("\tsearch(\"a.\") = " + wDict.search("a."));

        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println("\tall.getMinKey: " + allOne.getMinKey());
        allOne.dec("a");
        System.out.println("\tall.getMinKey: " + allOne.getMinKey());
        System.out.println("\tall.getMaxKey: " + allOne.getMaxKey());

        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(0);
        rc.insert(1);
        rc.insert(2);
        rc.insert(3);
        rc.insert(3);
        rc.remove(2);
        rc.remove(3);
        rc.remove(0);
        System.out.println("\trc.getRandom: " + rc.getRandom());
        System.out.println("\trc.getRandom: " + rc.getRandom());
        System.out.println("\trc.getRandom: " + rc.getRandom());
        System.out.println("\trc.getRandom: " + rc.getRandom());

        System.out.println();
        System.out.println("Test SummaryRanges:");
        SummaryRanges sr = new SummaryRanges();
        sr.addNum(1);
        System.out.println("\t" + sr.getIntervals());
        sr.addNum(3);
        System.out.println("\t" + sr.getIntervals());
        sr.addNum(7);
        System.out.println("\t" + sr.getIntervals());
        sr.addNum(2);
        System.out.println("\t" + sr.getIntervals());
        sr.addNum(7);
        System.out.println("\t" + sr.getIntervals());
        sr.addNum(6);
        System.out.println("\t" + sr.getIntervals());

        System.out.println();
        System.out.println("Test MedianFinder:");
        MedianFinder mf = new MedianFinder();
        System.out.println("\t" + mf.findMedian());
        mf.addNum(1);
        System.out.println("\t" + mf.findMedian());
        mf.addNum(0);
        System.out.println("\t" + mf.findMedian());
        mf.addNum(3);
        System.out.println("\t" + mf.findMedian());
        mf.addNum(2);
        System.out.println("\t" + mf.findMedian());
        mf.addNum(8);
        System.out.println("\t" + mf.findMedian());

        System.out.println();
        System.out.println("Test WordDistance:");
        WordDistance wd = new WordDistance(new String[]{
                "practice", "makes", "perfect", "coding", "makes"
        });
        System.out.println("\t" + wd.shortest("practice", "makes"));
        System.out.println("\t" + wd.shortest("practice", "perfect"));
        System.out.println("\t" + wd.shortest("practice", "coding"));
        System.out.println("\t" + wd.shortest("makes", "perfect"));
        System.out.println("\t" + wd.shortest("makes", "coding"));
        System.out.println("\t" + wd.shortest("perfect", "coding"));

        System.out.println();
        System.out.println("Test NumMatrix:");
        NumMatrix nm = new NumMatrix(new int[][]{
            {3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}
        });
        nm.print();
        System.out.println("\tnm.sumRegion(2,1,4,3) = " + nm.sumRegion(2,1,4,3));
        nm.update(3,2,2);
        nm.print();
        System.out.println("\tnm.sumRegion(2,1,4,3) = " + nm.sumRegion(2,1,4,3));
        System.out.println("\tnm.sum(2,1) = " + nm.sum(2,1));

        System.out.println();
        System.out.println("Test ZigzagIterator:");
        ZigzagIterator zi = new ZigzagIterator(
                new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2})),
                new ArrayList<Integer>(Arrays.asList(new Integer[]{3, 4, 5, 6}))
        );
        while (zi.hasNext()) {
            System.out.println("\t" + zi.next());
        }

        System.out.println();
        System.out.println("Test Vector2D:");
        List<Integer> l1 = new ArrayList<>(Arrays.asList(new Integer[]{1,2}));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(new Integer[]{3}));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(new Integer[]{}));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(new Integer[]{4,5,6}));
        List<Integer> l5 = new ArrayList<>(Arrays.asList(new Integer[]{}));
        List<List<Integer>> ll = new ArrayList<>();
        ll.add(l1);
        ll.add(l2);
        ll.add(l3);
        ll.add(l4);
        ll.add(l5);
        Vector2D2 v2d = new Vector2D2(ll);
        while (v2d.hasNext()) {
            System.out.println("\t" + v2d.next());
        }

        System.out.println();
        System.out.println("Test MovingAverage:");
        MovingAverage ma = new MovingAverage(3);
        System.out.println("\t" + ma.next(1));     // 1
        System.out.println("\t" + ma.next(10));   // (1 + 10) / 2
        System.out.println("\t" + ma.next(3));     // (1 + 10 + 3) / 3
        System.out.println("\t" + ma.next(5));     // (10 + 3 + 5) / 3

        System.out.println();
        System.out.println("Test Codec:");
        Codec codec = new Codec();
        String encoded = codec.encode(new ArrayList<>(Arrays.asList(new String[]{"a", "bc", "def"})));
        System.out.println("\tEncoded: " + encoded);
        List<String> decoded = codec.decode(encoded);
        System.out.println("\t" + decoded);

        encoded = codec.encode(new ArrayList<>(Arrays.asList(new String[]{"", "a", "", "bc", "def", ""})));
        System.out.println("\tEncoded: " + encoded);
        decoded = codec.decode(encoded);
        System.out.println("\t" + decoded);

        encoded = codec.encode(new ArrayList<>(Arrays.asList(new String[]{"0", "a", "", "bc", "def", ""})));
        System.out.println("\tEncoded: " + encoded);
        decoded = codec.decode(encoded);
        System.out.println("\t" + decoded);

        System.out.println();
        System.out.println("Test SnakeGame:");
        SnakeGame sg = new SnakeGame(3, 2, new int[][]{
                {1,2}, {0,1}
        });
        System.out.println("\t" + sg.move("R"));
        System.out.println("\t" + sg.move("D"));
        System.out.println("\t" + sg.move("R"));
        System.out.println("\t" + sg.move("U"));
        System.out.println("\t" + sg.move("L"));
        System.out.println("\t" + sg.move("U"));

        System.out.println();
        System.out.println("Test TicTacToe:");
        TicTacToe ttt = new TicTacToe(3);
        System.out.println("\t" + ttt.move(0,0,1));
        System.out.println("\t" + ttt.move(0,2,2));
        System.out.println("\t" + ttt.move(2,2,1));
        System.out.println("\t" + ttt.move(1,1,2));
        System.out.println("\t" + ttt.move(2,0,1));
        System.out.println("\t" + ttt.move(1,0,2));
        System.out.println("\t" + ttt.move(2,1,1));
    }
}
