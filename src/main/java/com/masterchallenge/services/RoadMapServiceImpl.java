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

    public Boolean areCitiesConnected(String origin, String destination){
        return roadMap.areCitiesConnected(origin, destination);
    }
}
