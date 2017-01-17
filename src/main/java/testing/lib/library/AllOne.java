package testing.lib.library;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Yun on 1/12/2017.
 */

/**
 * All O`one Data Structure
 *         Implement a data structure supporting the following operations:
 *         1. Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 *         2. Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 *         3. GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 *         4. GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 *         Challenge: Perform all these in O(1) time complexity.
 *         Subscribe to see which companies asked this question
 */
public class AllOne {

    private class Bucket {
        int cnt;
        Bucket prev;
        Bucket next;
        HashSet<String> keySet;
        public Bucket(int num) {
            cnt = num;
            keySet = new HashSet<>();
        }
    }
    private Bucket head;
    private Bucket tail;
    HashMap<Integer, Bucket> cntBucketMap;
    HashMap<String, Integer> keyCntMap;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        cntBucketMap = new HashMap<>();
        keyCntMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyCntMap.containsKey(key)) {
            update(key, 1);
        } else {
            keyCntMap.put(key, 1);
            if (head.next.cnt != 1) {
                addBucketAfter(head, new Bucket(1));
            }
            head.next.keySet.add(key);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyCntMap.containsKey(key)) {
            update(key, -1);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keySet.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keySet.iterator().next();
    }

    private void update(String key, int diff) {
        int preCnt = keyCntMap.get(key);
        int newCnt = preCnt + diff;
        keyCntMap.put(key, newCnt);
        if (keyCntMap.get(key) == 0) {
            keyCntMap.remove(key);
        }
        Bucket preBucket = cntBucketMap.get(preCnt);
        preBucket.keySet.remove(key);
        if (newCnt > 0) {
            if (cntBucketMap.containsKey(newCnt)) {
                cntBucketMap.get(newCnt).keySet.add(key);
            } else {
                Bucket newBucket = new Bucket(newCnt);
                newBucket.keySet.add(key);
                if (diff > 0) {
                    addBucketAfter(preBucket, newBucket);
                } else {
                    addBucketAfter(preBucket.prev, newBucket);
                }
            }
        }

        if (preBucket.keySet.isEmpty()) {
            removeBucket(preBucket);
        }
    }

    private void removeBucket(Bucket cur) {
        Bucket prev = cur.prev;
        Bucket next = cur.next;
        prev.next = next;
        next.prev = prev;
        cntBucketMap.remove(cur.cnt);
    }
    private void addBucketAfter(Bucket pre, Bucket newBucket) {
        Bucket next = pre.next;
        pre.next = newBucket;
        newBucket.prev = pre;
        newBucket.next = next;
        next.prev = newBucket;
        if (!cntBucketMap.containsKey(newBucket.cnt)) {
            cntBucketMap.put(newBucket.cnt, newBucket);
        }
    }
}
