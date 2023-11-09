package subway.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineRepositoryTest {

    LineRepository lineRepository = LineRepository.getInstance();

    @Test
    void initTest(){
        assertThat(lineRepository.getLines().size()).isEqualTo(3);
    }
}