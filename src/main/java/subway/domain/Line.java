package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final LineRepository lineRepository = LineRepository.getInstance();

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

    public static Line of(String name) {
        return lineRepository.getLines().stream().filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 노선은 존재하지 않습니다"));
    }

    public void decreaseInLineCountForStations() {
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

    public void addStation(Station station, int index) {
        validateIndex(index);
        stations.add(index, station);
    }

    private void validateIndex(int index) {
        if (index <= 0 || index >= (stations.size() - 1)) {
            throw new IllegalArgumentException("[ERROR]역과 역 사이에만 추가할 수 있습니다");
        }
    }

    public void deleteStation(Station station) {
        validate(station);
        stations.remove(station);
    }

    private void validate(Station station) {
        validateContain(station);
        validateOverTwoStations();
        ifEndStation(station);
    }

    private void validateContain(Station station) {
        if (!stations.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 해당 노선에 역이 존재하지 않습니다");
        }
    }

    public void validateNotContain(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 노선에 이미 해당 역이 존재합니다");
        }
    }

    private void validateOverTwoStations() {
        if (stations.size() <= 2) {
            throw new IllegalArgumentException("[ERROR] 노선에 역이 2개 이하입니다");
        }
    }

    private void ifEndStation(Station station) {
        if (station.equals(belowEndStation)) {
            belowEndStation = stations.get(stations.indexOf(belowEndStation) - 1);
        } else if (station.equals(upperEndStation)) {
            upperEndStation = stations.get(stations.indexOf(upperEndStation) + 1);
        }
    }

    public List<Station> getStations() {
        return stations;
    }
}
