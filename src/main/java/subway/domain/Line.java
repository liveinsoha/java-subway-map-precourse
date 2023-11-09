package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final LineRepository instance = LineRepository.getInstance();

    private String name;
    private Station upperEndStation;
    private Station belowEndStation;
    private List<Station> stations = new ArrayList<>();


    public Line(String name, Station upperEndStation, Station belowEndStation) {
        this.name = name;
        validateLineNameLength(name);
        upperEndStation.increaseInLineCount();
        belowEndStation.increaseInLineCount();
        this.upperEndStation = upperEndStation;
        this.belowEndStation = belowEndStation;
        stations.add(upperEndStation);
        stations.add(belowEndStation);
    }

    public Line(String name, Station upperEndStation, Station belowEndStation, List<Station> otherStations) {
        this.name = name;
        validateLineNameLength(name);
        upperEndStation.increaseInLineCount();
        belowEndStation.increaseInLineCount();
        this.upperEndStation = upperEndStation;
        this.belowEndStation = belowEndStation;
        stations.add(upperEndStation);
        stations.add(belowEndStation);
        otherStations.forEach(Station::increaseInLineCount);
        stations.addAll(otherStations);
    }

    public void decreaseInLineCountForStations(){
        stations.forEach(Station::decreaseInLineCount);
    }

    private void validateLineNameLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 노선 이름은 2글자 이상");
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
