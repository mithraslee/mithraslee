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
public class LRUCache3 {

    public LRUCache3(int capacity) {
        this.caches = new Cache (capacity);
    }
    
    public int get (int key) {
        if (caches.containsKey(key))
            return caches.get(key);
        return -1;
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
    
    private class Cache extends LinkedHashMap<Integer, Integer> {
        private final int capacity;

        public Cache(int capacity)
        {
            super(capacity, .75F, true);
            this.capacity = capacity;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }
    
    private Cache caches;
}


/*
public class LRUCache3 {

    public LRUCache3(int capacity) {
        this.caches = new Cache<> (capacity);
    }
    
    public int get (int key) {
        if (caches.containsKey(key))
            return caches.get(key);
        return -1;
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
    
    private class Cache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        public Cache(int capacity)
        {
            super(capacity);
            this.capacity = capacity;
        }

        private Cache() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }
    
    private Cache<Integer, Integer> caches;
}
*/