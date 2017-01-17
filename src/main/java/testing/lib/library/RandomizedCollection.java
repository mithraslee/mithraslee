package testing.lib.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by Yun on 1/12/2017.
 */
public class RandomizedCollection {

    private HashMap<Integer, HashSet<Integer>> valToPos;
    private ArrayList<Integer> vals;
    private Random random;
    private int cnt;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        valToPos = new HashMap<>();
        vals = new ArrayList<>();
        random = new Random();
        cnt = 0;
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToPos.containsKey(val)) {
            if (cnt == vals.size()) {
                vals.add(val);
                valToPos.get(val).add(cnt);
            } else {
                vals.set(cnt, val);
                valToPos.get(val).add(cnt);
            }
            cnt++;
            return false;
        } else {
            HashSet<Integer> newSet = new HashSet<>();
            newSet.add(cnt);
            if (cnt == vals.size()) {
                vals.add(val);
                valToPos.put(val, newSet);
            } else {
                vals.set(cnt, val);
                valToPos.put(val, newSet);
            }
            cnt++;
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!valToPos.containsKey(val)) {
            return false;
        } else {
            int lastVal = vals.get(cnt - 1);
            if (lastVal == val) {
                valToPos.get(val).remove(cnt - 1);
            } else {
                HashSet<Integer> posSet = valToPos.get(val);
                int pos = posSet.iterator().next();

                vals.set(pos, lastVal);
                valToPos.get(lastVal).remove(cnt - 1);
                valToPos.get(lastVal).add(pos);
                valToPos.get(val).remove(pos);
            }
            if (valToPos.get(val).isEmpty()) {
                valToPos.remove(val);
            }
            cnt--;
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        if (cnt == 0) {
            return 0;
        }
        return vals.get(random.nextInt(cnt));
    }
}
