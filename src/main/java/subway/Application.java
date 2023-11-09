package subway;

import subway.controller.CourseController;
import subway.controller.LineController;
import subway.controller.StationController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        CourseController controller = new CourseController();
        controller.run();
    }
}
