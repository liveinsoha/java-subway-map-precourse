package subway.domain;

import java.util.*;

public class StationRepository {
    private static final StationRepository instance = new StationRepository();
    private static final List<Station> stations = new ArrayList<>();

    public static StationRepository getInstance() {
        return instance;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    static {
        List<Station> list = Arrays.asList(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("양재시민의숲역"),
                new Station("매봉역"));
        stations.addAll(list);
    }

    public void addStation(Station station) {
        validateDuplicate(station);
        stations.add(station);

    }

    private void validateDuplicate(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역입니다");
        }
    }

    public void deleteStation(String name) {
        validateForDelete(name);
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private void validateForDelete(String name){
        validateExist(name);
        validateInLine(name);

    }

    private void validateInLine(String name) {
        if (Station.of(name).getInLineCount() != 0) {
            throw new IllegalArgumentException("[ERROR] 해당 역은 노선에 등록되어 있습니다");
        }
    }

    private void validateExist(String name) {
        if (stations.stream().noneMatch(station -> station.getName().equals(name))){
            throw new IllegalArgumentException("[ERROR] 해당 역은 존재하지 않습니다");
        }
    }
}
