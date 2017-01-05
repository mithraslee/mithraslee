package testing.lib.library.LFUCache;

import java.util.*;

/**
 * Created by Yun on 11/28/2016.
 */

// https://leetcode.com/problems/lfu-cache/
public class LFUCache {
    public LFUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
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
        }

        if (freqMap.containsKey(freq + 1)) {
            freqMap.get(freq + 1).add(node);
        } else {
            LinkedHashSet<CacheNode> newSet = new LinkedHashSet<>();
            newSet.add(node);
            freqMap.put(freq + 1, newSet);
        }
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
}
