package subway.service;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.StationDtos;


public class StationService {
    LineRepository lineRepository = LineRepository.getInstance();
    StationRepository stationRepository = StationRepository.getInstance();


    public void addStation(String stationName) {
        stationRepository.addStation(new Station(stationName));
    }

    public void deleteStation(String stationName) {
        stationRepository.deleteStation(stationName);
    }

    public StationDtos getStationsDto() {
        return StationDtos.of(stationRepository.getStations());
    }

}
