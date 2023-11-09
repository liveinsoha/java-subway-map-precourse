package subway.view.inputView;

import java.util.Scanner;

public class StationInputView {
    static final Scanner scanner = new Scanner(System.in);

    public static String getUserChoiceNumber(){
        return scanner.nextLine().trim();
    }

    public static String getStationNameInput() {
        return scanner.nextLine().trim();
    }
}
