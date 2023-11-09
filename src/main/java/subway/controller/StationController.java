package subway.controller;

import subway.service.StationService;
import subway.utils.Parser;
import subway.view.ErrorOutputView;
import subway.view.inputView.StationInputView;
import subway.view.outputView.StationOutputView;

import java.util.Arrays;

public class StationController {

    StationService stationService = new StationService();

    public void run() {

        while (true) {
            String userInput = getUserChoice();

            if (userInput.equals("1")) {
                addStation();
            } else if (userInput.equals("2")) {
                deleteStation();
            } else if (userInput.equals("3")) {
                showStations();
            } else if (userInput.equalsIgnoreCase("b")) {
                break;
            }
        }
    }

    private String getUserChoice() {
        try {
            return validateUserChoiceInput(StationInputView.getUserChoiceNumber());
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

    private void addStation() {
        try {
            stationService.addStation(StationInputView.getAddStationNameInput());
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printErrorMessage(e.getMessage());
        }
    }

    private void deleteStation() {
        try {
            stationService.deleteStation(StationInputView.getDeleteStationNameInput());
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printErrorMessage(e.getMessage());
        }
    }

    private void showStations(){
        StationOutputView.printStationInfo(stationService.getStationsDto());
    }
}


