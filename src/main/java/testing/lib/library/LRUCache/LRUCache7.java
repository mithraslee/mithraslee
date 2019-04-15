/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.library.LRUCache;

import java.util.*;

/**
 * Created by Yun on 4/12/2018.
 */
public class LRUCache7 {
    private class LRUCacheNode {
        public Integer val;
        public Integer key;
        public LRUCacheNode prev;
        public LRUCacheNode next;
        public LRUCacheNode(Integer v, Integer k, LRUCacheNode p, LRUCacheNode n) {
            val = v;
            key = k;
            prev = p;
            next = n;
        }
    }

    public LRUCache7(int capacity) {
        cap = capacity;
        head = new LRUCacheNode(null, null, null, null);
        tail = new LRUCacheNode(null, null, head, null);
        head.next = tail;
        cache = new HashMap<>();
    }

    private void promoteKey(int key) {
        if (cache.containsKey(key)) {
            LRUCacheNode node = cache.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
            node.prev = head;
        }
    }
    private void pop() {
        if (head.next != tail) {
            int removeKey = tail.prev.key;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            cache.remove(removeKey);
        }
    }
    private LRUCacheNode push(int value, int key) {
        LRUCacheNode newNode = new LRUCacheNode(value, key, head, head.next);
        head.next = newNode;
        newNode.next.prev = newNode;
        return newNode;
    }
    public int get (int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            promoteKey(key);
            return cache.get(key).val;
        }
    }

    public void set (int key, int value) {
        if (cache.containsKey(key)) {
            promoteKey(key);
            cache.get(key).val = value;
        } else {
            if (cap == cache.size()) {
                pop();
            }
            LRUCacheNode newNode = push(value, key);
            cache.put(key, newNode);
        }
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (Integer k : cache.keySet()) {
            sb.append("<").append(k).append(", ").append(cache.get(k)).append(">");
        }
        return sb.toString();
    }

    private int cap;
    private LRUCacheNode head;
    private LRUCacheNode tail;
    private HashMap<Integer, LRUCacheNode> cache;
}
