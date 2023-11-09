package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.LineDtos;

public class LineService {

    StationRepository stationRepository = StationRepository.getInstance();
    LineRepository lineRepository = LineRepository.getInstance();

    public void addLine(String lineName, Station upperEndStation, Station belowEndStation) {
       lineRepository.addLine(new Line(lineName, upperEndStation, belowEndStation));
    }

    public String validateLineNameDuplicate(String lineName) {
        lineRepository.validateDuplicate(lineName);
        return lineName;
    }

    public void deleteLine(String name) {
        lineRepository.deleteLineByName(name);
    }

    public LineDtos getLineDtos() {
        return LineDtos.of(lineRepository.getLines());
    }


}
