package testing.lib.library.LFUCache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Created by Yun on 11/28/2016.
 */

/**
 * LFU Cache
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 *      get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *      put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Follow up:
 *      Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 *      LFUCache cache = new LFUCache( 2 ); //
 *      cache.put(1, 1);
 *      cache.put(2, 2);
 *      cache.get(1);       // returns 1
 *      cache.put(3, 3);    // evicts key 2
 *      cache.get(2);       // returns -1 (not found)
 *      cache.get(3);       // returns 3.
 *      cache.put(4, 4);    // evicts key 1.
 *      cache.get(1);       // returns -1 (not found)
 *      cache.get(3);       // returns 3
 *      cache.get(4);       // returns 4
 *
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache2 {
    public LFUCache2(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        freqs = new TreeSet<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            increaseFreq(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (cap == 0) return;
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            node.value = value;
            increaseFreq(node);
            cache.put(key, node);
        } else {
            CacheNode newNode = new CacheNode(key, value, 0);
            if (cache.size() == cap) {
                int smallestFreq = 1;
                while (!freqMap.containsKey(smallestFreq)) {
                    smallestFreq++;
                }
                System.out.println(smallestFreq);
                System.out.println(freqMap.get(smallestFreq).size());
                Iterator<CacheNode> iter = freqMap.get(smallestFreq).iterator();
                CacheNode nodeToRemove = iter.next();
                freqMap.get(smallestFreq).remove(nodeToRemove);
                if (freqMap.get(smallestFreq).isEmpty()) {
                    freqMap.remove(smallestFreq);
                }
                cache.remove(nodeToRemove.key);
            }
            increaseFreq(newNode);
            cache.put(key, newNode);
        }
    }

    private void increaseFreq(CacheNode node) {
        int freq = node.frequency;
        node.frequency = freq + 1;

        if (freqMap.containsKey(freq)) {
            freqMap.get(freq).remove(node);
            if (freqMap.get(freq).isEmpty()) {
                freqMap.remove(freq);
            }
            freqs.remove(freq);
        }

        if (freqMap.containsKey(freq + 1)) {
            freqMap.get(freq + 1).add(node);
        } else {
            LinkedHashSet<CacheNode> newSet = new LinkedHashSet<>();
            newSet.add(node);
            freqMap.put(freq + 1, newSet);
        }
        freqs.add(freq + 1);
    }

    private class CacheNode {
        public int key;
        public int value;
        public int frequency;
        public CacheNode(int k, int v, int f) {
            key = k;
            value = v;
            frequency = f;
        }
        @Override
        public String toString() {
            return "(K: " + key + "; V: " + value + "; F: " + frequency + ")";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyNode Cahce\n");
        for (int k : cache.keySet()) {
            sb.append("\t" + k + " => " + cache.get(k) + "\n");
        }
        sb.append("Freq Nodes Map\n");
        for (int f : freqMap.keySet())
            sb.append("\t" + f + " => " + freqMap.get(f) + "\n");
        return sb.toString();
    }

    private int cap;
    private HashMap<Integer, CacheNode> cache;
    private HashMap<Integer, LinkedHashSet<CacheNode>> freqMap;
    private TreeSet<Integer> freqs;
}
