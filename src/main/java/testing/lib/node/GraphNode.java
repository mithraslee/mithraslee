/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.node;

import java.util.*;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author yunl
 */
public class GraphNode <T extends Number> extends Node<T> {
    public GraphNode(Integer id, T d) {
        super(d);
        this.id = id;
        this.distance = Integer.MAX_VALUE;
        neighbors = new HashMap<> ();
    }
    
    public GraphNode(Integer id, T d, HashMap<GraphNode<T>, Integer> map) {
        this (id, d);
        neighbors.putAll(map);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID=").append(id).append(" (V=").append(super.getData()).append("; N=[ ");
        Iterator<Map.Entry<GraphNode<T>,Integer>> iter = neighbors.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<GraphNode<T>,Integer> e = iter.next();
            sb.append(e.getKey().id).append("<").append(e.getValue()).append("> ");
        }
        sb.append("]");
        return sb.toString();
    }
    
    public Integer id;
    // Map: node => connection cost
    public HashMap<GraphNode<T>, Integer> neighbors;
    public Integer distance;
}
