package com.masterchallenge.services;

import com.masterchallenge.repository.RoadMapRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;


@Service
public class RoadMapServiceImpl implements RoadMapService {

    Logger logger = LoggerFactory.getLogger(RoadMapServiceImpl.class);

    @Autowired
    RoadMapRepository roadMap;

    public RoadMapServiceImpl() {
    }

    public Boolean areCitiesConnected(String origin, String destination) throws IOException{
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
        } catch (FileNotFoundException fnfException){
            logger.error(fnfException.getMessage(), fnfException);
            throw  fnfException;
        } catch (IOException ioException) {
            logger.error("Error processing the file", ioException);
            throw ioException;
        }
        return found;
    }
}
