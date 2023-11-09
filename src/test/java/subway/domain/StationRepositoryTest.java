package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StationRepositoryTest {
    StationRepository stationRepository;
    LineRepository lineRepository;

    @BeforeEach
    void setUp() {
        stationRepository = StationRepository.getInstance();
        lineRepository = LineRepository.getInstance();

    }

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

    @Test
    void addTest() {
        stationRepository.addStation(new Station("철산역"));
        assertThat(stationRepository.getStations().size()).isEqualTo(8);
    }

    @Test
    void deleteTest() {
        assertThatThrownBy(() -> stationRepository.deleteStation("교대역")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당 역은 노선에 등록되어 있습니다");
    }

    @Test
    void deleteTest2() {
        assertThatThrownBy(() -> stationRepository.deleteStation("철산역")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당 역은 존재하지 않습니다");
    }

}