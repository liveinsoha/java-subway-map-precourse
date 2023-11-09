package subway.dto;

import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StationDtos {

    List<StationDto> stationDtos = new ArrayList<>();

    private StationDtos(StationRepository stationRepository) {
        stationDtos = stationRepository.getStations().stream()
                .map(StationDto::of)
                .collect(Collectors.toList());
    }

    public static StationDtos of(StationRepository stationRepository) {
        return new StationDtos(stationRepository);
    }

    public List<StationDto> getStationDtos() {
        return stationDtos;
    }
}
