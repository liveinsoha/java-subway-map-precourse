package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class CourseService {
    LineRepository lineRepository = LineRepository.getInstance();
    StationRepository stationRepository = StationRepository.getInstance();

    public void addCourse(Line line, Station station, int index) {
        line.addStation(station, index);
    }

    public void deleteCourse(Line line, Station station) {
        line.deleteStation(station);
    }

    public void validateNotContain(Line line, Station station) {
        line.validateNotContain(station);
    }

}
