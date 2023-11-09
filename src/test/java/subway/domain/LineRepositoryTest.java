package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineRepositoryTest {

    StationRepository stationRepository = StationRepository.getInstance();
    LineRepository lineRepository = LineRepository.getInstance();

    @Test
    void initTest() {
        assertThat(lineRepository.getLines().size()).isEqualTo(3);
    }

    @Test
    void duplicateTest() {
        assertThatThrownBy(() -> lineRepository.validateDuplicate("2호선"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void notExistTest() {
        assertThatThrownBy(() -> lineRepository.deleteLineByName("철산역")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void decreaseInLineTest() {

        int inLineCount1 = Station.of("교대역").getInLineCount();
        int inLineCount2 = Station.of("강남역").getInLineCount();
        lineRepository.deleteLineByName("2호선");
        assertThat(Station.of("교대역").getInLineCount()).isEqualTo(inLineCount1 - 1);
        assertThat(Station.of("강남역").getInLineCount()).isEqualTo(inLineCount2 - 1);

    }
}