/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.library.LRUCache;

import java.util.*;

/**
 *
 * @author yunl
 */

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 *
 *     get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *     set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

public class LRUCache {
    public static class KeyFreq implements Comparable<KeyFreq> {
        /**
         *
         * @param k
         * @param f
         */
        public KeyFreq (int k, int f) {
            key = k;
            freq = f;
        }
        public int key;
        public int freq;
        
        @Override
        public String toString () {
            return "<" + key + ", " + freq + ">";
        }

        @Override
        public int compareTo(KeyFreq o) {
            return Integer.compare(freq, o.freq);
        }
    }
    
    public LRUCache (int capability) {
        sizeLimit = capability;
//        keyFreqToValue = new TreeMap<> (new Comparator<KeyFreq> () {
//            public int compare (KeyFreq kf1, KeyFreq kf2) {
//                return Integer.compare(kf1.freq, kf2.freq);
//            }
//        });
        frequency = new PriorityQueue<> ();
//        frequency = new PriorityQueue<> (0, new Comparator<KeyFreq> () {
//            public int compare (KeyFreq kf1, KeyFreq kf2) {
//                return Integer.compare(kf1.freq, kf2.freq);
//            }
//        });
        caches = new HashMap<> ();
    }
    
    public Integer get (int key) {
        if (!caches.containsKey(key)) {
            return null;
        }
        else {
            /* Pay attention to this piece of code
             * You cannot modify/remove the element using foreach
             * Using iterator, you can remove element, but not modify
             */
            List<KeyFreq> toAdd = new ArrayList<> ();
            Iterator it = frequency.iterator();
            
            while (it.hasNext()) {
                KeyFreq kf = (KeyFreq)it.next();
                
                if (kf.key == key) {
                    it.remove();
                    toAdd.add(new KeyFreq(kf.key, kf.freq + 1));
                    break;
                }
            }
            frequency.addAll(toAdd);
            return caches.get(key);
        }
    }
    
    public void set (int key, int value) {
        if (!caches.containsKey(key)) {
            if (caches.size() == sizeLimit) {
                KeyFreq kf = frequency.poll();
                caches.remove(kf.key);
            }
            caches.put(key, value);
            frequency.add(new KeyFreq(key, 1));
        }
    }
    
    public Integer size () {
        if (caches.size() != frequency.size()) {
            System.out.println("Size does not match between caches & frequency!");
            return null;
        } else {
            return caches.size();
        }
    }
    
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder ();
        
        sb.append("Cache size: ").append(size()).append("; Limit: ").append(sizeLimit).append("\n");
        sb.append("KeyToFreq: ").append(caches).append("\n");
        sb.append("keyFreqToValue: ").append(frequency).append("\n");
        return sb.toString();
    }
    
    private int sizeLimit;
    private PriorityQueue <KeyFreq> frequency;
    private HashMap <Integer, Integer> caches;
//    private HashMap <Integer, Integer> keyToFreq;
//    private TreeMap <LRUCache.KeyFreq, Integer> keyFreqToValue;
}
