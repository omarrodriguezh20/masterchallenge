package com.masterchallenge.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Adjacent list graph implementation, adapted from
 * https://www.geeksforgeeks.org/implementing-generic-graph-in-java/
 * <p>
 * In this solution the set of key acts as the first list and the values are the
 * adjancent lists.
 */
public class RoadmapGraph<T> {

    private Map<T, List<T>> map = new HashMap<>();

    /**
     * Adds a new vertex to the graph
     */
    public void addVertex(T vertex) {
        map.put(vertex, new LinkedList<>());
    }

    /**
     * Adds the edge between source and destination
     */
    public void addEdge(T source, T destination, boolean bidirectional) {

        if (!map.containsKey(source)) {
            addVertex(source);
        }

        if (!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    /**
     * Return count of vertices
     */
    public int getVertexCount() {
        return map.keySet().size();
    }

    public List<T> getReachableNodes(T from) {
        return map.get(from);
    }

}
