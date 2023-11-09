package subway;

import subway.controller.StationController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        StationController stationController = new StationController();
        stationController.run();
    }
}
