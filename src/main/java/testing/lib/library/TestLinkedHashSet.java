/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing.lib.library;

import java.util.*;

/**
 *
 * @author yunl
 */
    
class CacheSet extends LinkedHashSet<Integer> {
    private final int capacity;

    public CacheSet(int capacity)
    {
        super(capacity);
        this.capacity = capacity;
    }

    // @Override
    protected boolean removeEldestEntry(Object item) {
        return size() > capacity;
//        LinkedHashSet<Integer> newSet = Collections.newSetFromMap
    }
}