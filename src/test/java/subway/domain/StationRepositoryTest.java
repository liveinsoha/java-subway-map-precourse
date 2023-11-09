package subway.domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;

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

    @Test
    void testInLineCount() {
        LineRepository lineRepository = LineRepository.getInstance();
        Optional<Station> station1 = stationRepository
                .getStations().stream()
                .filter(station -> station.getName().equals("교대역")).findFirst();

        assertThat(station1.get().getInLineCount()).isEqualTo(2);

    }

}