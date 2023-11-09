package subway.service;

import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.Station;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    CourseService courseService = new CourseService();

    @Test
    void addTest(){
        assertThatThrownBy(()->courseService.addCourse(Line.of("2호선"), Station.of("철산역"),2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당역은 존재하지 않습니다");
    }

    @Test
    void addTest2(){
        courseService.addCourse(Line.of("2호선"), Station.of("양재역"),1);

    }
}