package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineService {

    StationRepository stationRepository = StationRepository.getInstance();
    LineRepository lineRepository = LineRepository.getInstance();

    public void addLine(String lineName, Station upperEndStation, Station belowEndStation) {
        new Line(lineName, upperEndStation, belowEndStation);
    }

    public String validateLineNameDuplicate(String lineName) {
        lineRepository.validateDuplicate(lineName);
        return lineName;
    }



}
