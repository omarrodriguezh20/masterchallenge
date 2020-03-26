package com.masterchallenge.services;

import com.masterchallenge.repository.RoadMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoadMapServiceImpl implements RoadMapService {

    @Autowired
    RoadMapRepository roadMap;

    public RoadMapServiceImpl() {
    }

    public Boolean areCitiesConnected(String origin, String destination) {
        boolean found = false;
        try {
            roadMap.loadRoadMap();
            roadMap.setOrigin(origin);
            roadMap.setDestination(destination);
            while (true) {
                if (!roadMap.hasCurrentCity()) {
                    break;
                }
                if (roadMap.haveReachDestination()) {
                    found = true;
                    break;
                }
                roadMap.travel();
            }
        } catch (Exception exception){
            System.out.println(exception);
        }
        return found;
    }
}
