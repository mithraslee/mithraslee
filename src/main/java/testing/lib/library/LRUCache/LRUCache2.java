/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.library.LRUCache;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author mithr_000
 */
public class LRUCache2 {
    public LRUCache2(int capacity) {
        cap = capacity;
        caches = new LinkedHashMap<Integer,Integer>(capacity, .75F, false) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return caches.size() > cap;
            }
        };
    }
    
    public int get (int key) {
        if (!caches.containsKey(key)) {
            return -1;
        }
        else {
            return caches.get(key);
        }
    }
    
    public void set (int key, int value) {
        caches.put(key, value);
    }
    
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (Integer k : caches.keySet()) {
            sb.append("<").append(k).append(", ").append(caches.get(k)).append(">");
        }
        return sb.toString();
    }
    private int cap;
    private LinkedHashMap<Integer, Integer> caches;
}
