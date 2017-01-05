/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing.lib.library.LRUCache;

import java.util.*;

/**
 *
 * @author yunl
 */
public class LRUCache4 extends LinkedHashMap<Integer, Integer> {
    public LRUCache4(int capacity) {
        super(capacity, .75F, false);  // The insertion order
        //super(capacity, .75F, true); // The access order
        this.capacity = capacity;
    }
    
    public int get (int key) {
        if (!this.containsKey(key)) // If use super.containsKey, there will be timeout. Why?
            return -1;
        else
            return super.get(key);
    }
    
    public void set (int key, int value) {
        super.put(key, value);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
    
    private final int capacity;
}
