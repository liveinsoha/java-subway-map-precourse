package subway.service;

import org.junit.jupiter.api.Test;
import subway.domain.Station;

import javax.xml.ws.Service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineServiceTest {

    LineService lineService = new LineService();

    @Test
    void addTest() {
        int inLineCount = Station.of("교대역").getInLineCount();
        lineService.addLine("1호선", Station.of("교대역"), Station.of("강남역"));
        assertThat(Station.of("교대역").getInLineCount()).isEqualTo(inLineCount+1);
    }


}