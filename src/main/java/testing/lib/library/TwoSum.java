package testing.lib.library;

import java.util.HashMap;

/**
 * Created by Yun on 1/16/2017.
 */
public class TwoSum {

    HashMap<Integer, Integer> map = new HashMap<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int n : map.keySet()) {
            int t = value - n;
            if ((t != n && map.containsKey(t)) ||
                (t == n && map.get(t) > 1)) {
                return true;
            }
        }
        return false;
    }
}
