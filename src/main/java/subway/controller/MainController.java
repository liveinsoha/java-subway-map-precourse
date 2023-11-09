package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.dto.LineDto;
import subway.dto.StationDtos;
import subway.view.inputView.MainInputView;
import subway.view.outputView.MainOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainController {

    LineRepository lineRepository = LineRepository.getInstance();

    StationController stationController = new StationController();
    LineController lineController = new LineController();
    CourseController courseController = new CourseController();

    public void run() {

        while ((true)) {
            String userChoice = getUserChoice();

            if (userChoice.equals("1")) {
                stationController.run();
            } else if (userChoice.equals("2")) {
                lineController.run();
            } else if (userChoice.equals("3")) {
                courseController.run();
            } else if (userChoice.equals("4")) {
                printAll();
            } else if (userChoice.equalsIgnoreCase("q")) {
                break;
            }
        }

    }

    private String getUserChoice() {
        return validateUserChoiceInput(MainInputView.getUserChoiceNumber());
    }

    private String validateUserChoiceInput(String input) {
        if (!Arrays.asList("1", "2", "3", "4", "Q", "q").contains(input)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다");
        }
        return input;
    }

    private void printAll() {
        MainOutputView.printAll(getLineDto(), getStationDtos());
    }

    private List<LineDto> getLineDto() {
        return lineRepository.getLines()
                .stream()
                .map(LineDto::of)
                .collect(Collectors.toList());
    }

    private List<StationDtos> getStationDtos() {
        return lineRepository.getLines()
                .stream()
                .map(Line::getStations)
                .map(StationDtos::of)
                .collect(Collectors.toList());
    }

}
