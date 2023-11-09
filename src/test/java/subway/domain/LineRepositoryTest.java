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
}