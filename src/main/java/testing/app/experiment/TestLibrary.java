package testing.app.experiment;

import testing.lib.library.*;
import testing.lib.library.LFUCache.LFUCache;
import testing.lib.library.LRUCache.*;

import java.io.Console;
import java.util.ArrayList;
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
    }
}
