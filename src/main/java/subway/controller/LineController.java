package subway.controller;

import subway.domain.Station;
import subway.service.LineService;
import subway.view.ErrorOutputView;
import subway.view.inputView.LineInputView;
import subway.view.inputView.StationInputView;
import subway.view.outputView.LineOutputView;

import java.util.Arrays;

public class LineController {

    LineService lineService = new LineService();

    public void run() {
        while (true) {
            String userInput = getUserChoice();

            if (userInput.equals("1")) {
                addLine();
            } else if (userInput.equals("2")) {
                deleteLine();
            } else if (userInput.equals("3")) {
                showLines();
            } else if (userInput.equalsIgnoreCase("b")) {
                break;
            }
        }
    }

    private String getUserChoice() {
        try {
            return validateUserChoiceInput(LineInputView.getUserChoiceNumber());
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printErrorMessage(e.getMessage());
            return getUserChoice();
        }
    }

    private String validateUserChoiceInput(String input) {
        if (!Arrays.asList("1", "2", "3", "b", "B").contains(input)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다");
        }
        return input;
    }

    private void addLine() {
        try {
            lineService.addLine(getLineNameInput(), getUpperEndStation(), getBelowEndStation());
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printErrorMessage(e.getMessage());
        }

    }

    private String getLineNameInput() {
        return lineService.validateLineNameDuplicate(LineInputView.getAddLineNameInput());
    }

    private Station getUpperEndStation() {
        return Station.of(LineInputView.getUpperEndStationName());
    }

    private Station getBelowEndStation() {
        return Station.of(LineInputView.getBelowEndStationName());
    }

    private void deleteLine() {
        try {
            lineService.deleteLine(LineInputView.getDeleteLineNameInput());
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printErrorMessage(e.getMessage());
        }
    }

    private void showLines() {
        LineOutputView.printLinesInfo(lineService.getLineDtos());
    }
}
