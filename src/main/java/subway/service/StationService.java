package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    StationRepository stationRepository = StationRepository.getInstance();


    public void addStation(String stationName){
        stationRepository.addStation(new Station(stationName));
    }

    
}
