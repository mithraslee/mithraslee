package testing.lib.library.LRUCache;

import java.util.*;

public class LRUCache6 {
    
    public LRUCache6(int capacity) {
        cap = capacity;
        order = new LinkedHashSet<> ();
        caches = new HashMap<> ();
    }
    
    public int get(int key) {
        if (caches.containsKey(key)) {
            moveToEnd(key);
            return caches.get(key);
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (caches.containsKey(key)) {
            moveToEnd(key);
        } else {
            if (caches.size() == cap) {
                Iterator<Integer> iter = order.iterator();
                Integer first = iter.next();
                caches.remove(first);
                order.remove(first);
            }
            order.add(key);
        }
        caches.put(key, value);
    }
    
    private void moveToEnd(int key) {
        order.remove(key);
        order.add(key);
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (Integer k : caches.keySet()) {
            sb.append("<").append(k).append(", ").append(caches.get(k)).append(">");
        }
        return sb.toString();
    }
    private final int cap;
    LinkedHashSet<Integer> order;
    HashMap<Integer, Integer> caches;
}
