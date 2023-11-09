package subway.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StationServiceTest {

    StationService stationService = new StationService();

    @Test
    void addTest(){
       assertThatThrownBy(() ->stationService.addStation("교대역")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void deleteTest(){
        assertThatThrownBy(() ->stationService.deleteStation("철산역")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void deleteTest2(){
        assertThatNoException().isThrownBy(() -> stationService.deleteStation("교대역"));
    }

}