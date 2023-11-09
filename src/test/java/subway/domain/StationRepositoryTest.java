package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StationRepositoryTest {

    StationRepository stationRepository = StationRepository.getInstance();

    @Test
    void initTest() {
        assertThat(stationRepository.getStations().size()).isEqualTo(7);
    }

    @Test
    void validateDuplicateTest() {
        assertThatThrownBy(() -> stationRepository.addStation(new Station("강남역"))).isInstanceOf(IllegalArgumentException.class);
    }

}