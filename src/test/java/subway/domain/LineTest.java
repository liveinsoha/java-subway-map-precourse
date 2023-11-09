package subway.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @ParameterizedTest
    @ValueSource(strings = {"가", "나", "밤"})
    void nameLengthTest(String input) {
        Station station1 = new Station("광명역");
        Station station2 = new Station("철산역");
        assertThatThrownBy(() -> new Line(input, station1, station2)).isInstanceOf(IllegalArgumentException.class);
    }
}