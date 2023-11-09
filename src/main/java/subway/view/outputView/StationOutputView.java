package subway.view.outputView;


import subway.dto.StationDtos;

public class StationOutputView {


    public static void printStationInfo(StationDtos stationsDto) {
        stationsDto.getStationDtos()
                .forEach(stationDto -> System.out.println("[INFO] " + stationDto.getName()));
    }
}
