package subway.view.outputView;

import subway.dto.LineDto;
import subway.dto.StationDto;
import subway.dto.StationDtos;

import java.util.List;

public class MainOutputView {

    public static void printAll(List<LineDto> lineDtos, List<StationDtos> stationDtosList) {
        for (int i = 0; i < lineDtos.size(); i++) {
            System.out.println("[INFO] " + lineDtos.get(i).getName());
            System.out.println("[INFO] ---");
            stationDtosList.get(i).getStationDtos()
                    .forEach(stationDto -> System.out.println("[INFO] " + stationDto.getName()));
            System.out.println();
        }

    }
}
