package subway.dto;

import subway.domain.Station;

public class StationDto {
    String name;

    private StationDto(String name) {
        this.name = name;
    }

    public static StationDto of(Station station) {
        return new StationDto(station.getName());
    }

    public String getName() {
        return name;
    }
}
