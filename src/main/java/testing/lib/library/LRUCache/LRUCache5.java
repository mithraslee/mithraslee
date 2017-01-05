/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing.lib.library.LRUCache;

import java.util.*;

public class LRUCache5 {
    
    public LRUCache5(int capacity) {
        cap = capacity;
        order = new LinkedList<> ();
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
                caches.remove(order.getFirst());
                order.removeFirst();
            }
            order.addLast(key);
        }
        caches.put(key, value);
    }
    
    private void moveToEnd(int key) {
        int index = order.indexOf(key);
        if (index != -1) {
            order.remove(index);
            order.addLast(key);
        }
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
    LinkedList<Integer> order;
    HashMap<Integer, Integer> caches; // = new HashMap<> ();
}