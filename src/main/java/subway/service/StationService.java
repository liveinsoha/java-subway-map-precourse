package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    StationRepository stationRepository = StationRepository.getInstance();


    public void addStation(String stationName){
        stationRepository.addStation(new Station(stationName));
    }

    public void deleteStation(String stationName){
        if(!stationRepository.deleteStation(stationName)){
            throw new IllegalArgumentException("[ERROR]해당역은 존재하지 않습니다");
        }
    }

}
