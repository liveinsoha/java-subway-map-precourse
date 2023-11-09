package subway.dto;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StationDtos {

    List<StationDto> stationDtos = new ArrayList<>();

    private StationDtos(List<Station> stations) {
        stationDtos = stations.stream()
                .map(StationDto::of)
                .collect(Collectors.toList());
    }



    public static StationDtos of(List<Station> stations) {
        return new StationDtos(stations);
    }

    public List<StationDto> getStationDtos() {
        return stationDtos;
    }

}
