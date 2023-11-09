package subway;

import subway.controller.LineController;
import subway.controller.StationController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        LineController lineController = new LineController();
        lineController.run();
    }
}
