package subway.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.service.CourseService;
import subway.utils.Parser;
import subway.view.ErrorOutputView;
import subway.view.inputView.CourseInputView;
import subway.view.inputView.LineInputView;

import java.util.Arrays;

public class CourseController {

    CourseService courseService = new CourseService();

    public void run() {
        while (true) {
            String userInput = getUserChoice();
            if (userInput.equals("1")) {
                addCourse();
            } else if (userInput.equals("2")) {
                deleteCourse();
            } else if (userInput.equalsIgnoreCase("b")) {
                break;
            }
        }
    }

    private String getUserChoice() {
        try {
            return validateUserChoiceInput(CourseInputView.getUserChoiceNumber());
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printErrorMessage(e.getMessage());
            return getUserChoice();
        }
    }

    private String validateUserChoiceInput(String input) {
        if (!Arrays.asList("1", "2", "b", "B").contains(input)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다");
        }
        return input;
    }

    private void addCourse() {
        try {
            Line line = getAddCourseLine();
            Station station = getAddCourseStation();
            courseService.validateNotContain(line, station);
            courseService.addCourse(line, station, getAddCourseIndex());
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printErrorMessage(e.getMessage());
        }
    }

    private void deleteCourse() {
        try {
            courseService.deleteCourse(getDeleteCourseLine(), getDeleteCourseStation());
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printErrorMessage(e.getMessage());
        }
    }


    private Line getAddCourseLine() {
        return Line.of(CourseInputView.getAddCourseLineName());
    }

    private Station getAddCourseStation() {
        return Station.of(CourseInputView.getAddCourseStationName());

    }

    private int getAddCourseIndex() {
        return Parser.parseToInt(CourseInputView.getAddCourseIndex());
    }

    private Line getDeleteCourseLine() {
        return Line.of(CourseInputView.getDeleteCourseLineName());
    }

    private Station getDeleteCourseStation() {
        return Station.of(CourseInputView.getDeleteCourseStationName());

    }


}

