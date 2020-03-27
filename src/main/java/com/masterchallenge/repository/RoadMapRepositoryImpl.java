package com.masterchallenge.repository;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;


/**
 * Graph based implementation, any two nodes are connected in both ways (in and out)
 */
@Repository
public class RoadMapRepositoryImpl implements RoadMapRepository {

    private RoadmapGraph<String> roadmapGraph = RoadMapSingleton.getInstance();

    public RoadMapRepositoryImpl() {
    }


    public RoadmapGraph<String> getRoadMap() {
        return this.roadmapGraph;
    }

    @Override
    /*
      Find the connection between the cities with DFS (Deept First Search)
      https://en.wikipedia.org/wiki/Depth-first_sear
     */
    public boolean areCitiesConnected(String origin, String destination) {
        List<String> todo = new LinkedList<>();
        List<String> done = new LinkedList<>();

        todo.add(origin);

        while (todo.size() > 0) {
            String vertex = todo.get(0);
            todo.remove(0);
            done.add(vertex);
            for (String dest : roadmapGraph.getReachableNodes(vertex)) {
                if (destination.equals(dest)) {
                    return true;
                }
                if (!done.contains(dest)) {
                    todo.add(dest);
                }
            }
        }
        return false;
    }
}
