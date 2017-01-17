package testing.lib.library;

/**
 * Created by Yun on 1/12/2017.
 */

import java.util.*;

/**
 *Insert Delete GetRandom O(1)
 *        Design a data structure that supports all following operations in average O(1) time.
 *        1. insert(val): Inserts an item val to the set if not already present.
 *        2. remove(val): Removes an item val from the set if present.
 *        3. getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *        Example:
 * Init an empty set.
 *        RandomizedSet randomSet = new RandomizedSet();
 * Inserts 1 to the set. Returns true as 1 was inserted successfully.
 *        randomSet.insert(1);
 * Returns false as 2 does not exist in the set.
 *        randomSet.remove(2);
 * Inserts 2 to the set, returns true. Set now contains [1,2].
 *        randomSet.insert(2);
 * getRandom should return either 1 or 2 randomly.
 *        randomSet.getRandom();
 * Removes 1 from the set, returns true. Set now contains [2].
 *        randomSet.remove(1);
 * 2 was already in the set, so return false.
 *        randomSet.insert(2);
 * Since 2 is the only number in the set, getRandom always return 2.
 *        randomSet.getRandom();
 */

public class RandomizedSet2 {

    private HashMap<Integer, Integer> valToPos;
    private ArrayList<Integer> vals;
    private Random random;
    private int cnt;

    /** Initialize your data structure here. */
    public RandomizedSet2() {
        valToPos = new HashMap<>();
        vals = new ArrayList<>();
        random = new Random();
        cnt = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToPos.containsKey(val)) {
            return false;
        } else {
            if (cnt == vals.size()) {
                vals.add(val);
                valToPos.put(val, vals.size() - 1);
            } else {
                vals.set(cnt, val);
                valToPos.put(val, cnt);
            }
            cnt++;
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToPos.containsKey(val)) {
            return false;
        } else {
            int pos = valToPos.get(val);
            if (pos != cnt - 1) {
                int lastVal = vals.get(cnt - 1);
                vals.set(pos, lastVal);
                valToPos.put(lastVal, pos);
            }
            valToPos.remove(val);
            cnt--;
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (cnt == 0) {
            return 0;
        }
        return vals.get(random.nextInt(cnt));
    }
}