package subway.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StationTest {


    @ParameterizedTest
    @ValueSource(strings = {"나", "라", "뺠", "역"})
    void validateNameLengthTest(String input) {
        assertThatThrownBy(() -> new Station(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equalsTest() {
        Station station1 = new Station("역삼역");
        Station station2 = new Station("역삼역");
        assertThat(station1.equals(station2)).isTrue();
    }

    @Test
    void increaseTest(){
        Station station1 = new Station("역삼역");
        station1.increaseInLineCount();
        assertThat(station1.getInLineCount()).isEqualTo(1);
    }
}