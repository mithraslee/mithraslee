/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.library;

import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;

/**
 *
 * @author yunl
 */
public class GasCost {
    // TODO: This question's implementation & test is moved to ArrayTest module

    /*
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
     * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
     * Note:
     *  The solution is guaranteed to be uniq
     */
    public static int canCompleteCircuit(Integer[] gas, Integer[] cost) {
        System.out.println("\nStart function canCompleteCircuit()");
        int len1 = gas.length;
        int len2 = cost.length;
        if (len1 != len2 || len1 == 0)
            return -1;

        System.out.println("\tGAS:   " + Arrays.asList(gas));
        System.out.println("\tCOST:  " + Arrays.asList(cost));
        Integer[] route = new Integer[len1];
        Integer total = 0;
        Integer sum = 0;
        Integer start = 0;
        for (int i = 0, index = 0; i < len1; i++) {
            route[index++] = gas[i] - cost[i];
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        System.out.println("\tROUTE:  " + Arrays.asList(route));
        if (total < 0) {
            System.out.println("\tCannot complete!");
            return -1;
        } else {
            System.out.println("\tStart point = " + start);
            return start;
        }
    }

//    public static HashSet<Integer> canCompleteCircuit(Integer[] gas, Integer[] cost) {
//        int len1 = gas.length;
//        int len2 = cost.length;
//        if (len1 != len2 || len1 == 0)
//            return null;
//
//        System.out.println("GAS:   " + Arrays.asList(gas));
//        System.out.println("COST:  " + Arrays.asList(cost));
//        Integer [] route = new Integer [2 * len1];
//        Integer sum = 0;
//        for (int i = 0, index = 0; i < len1; i++) {
//            route[index++] = gas[i] - cost[i];
//            sum += gas[i] - cost[i];
//        }
//        if (sum < 0) return null;
//
//        System.out.println("ROUTE: " + Arrays.asList(route));
//        HashSet<Integer> startPoints = new HashSet<> ();
//        for (int i = 0; i < len1; i++) {
//            if (canFinish(route, i)) {
//                startPoints.add(i);
//            }
//        }
//
//        System.out.println("The possible start points are: " + startPoints);
//        return startPoints;
//    }
    private static boolean canFinish (Integer [] route, int start) {
        int sum = 0;
        int len = route.length;
        for (int i = 0; i < len; i++) {
            sum += route[(int)((i + start)%len)];
            if (sum < 0)
                return false;
        }
        return true;
    }
}
