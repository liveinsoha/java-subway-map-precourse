package subway.view.inputView;

import java.util.Scanner;

public class StationInputView {
    static final Scanner scanner = new Scanner(System.in);

    public static String getUserChoiceNumber() {
        System.out.println("## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기");
        return scanner.nextLine().trim();
    }

    public static String getAddStationNameInput() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return scanner.nextLine().trim();
    }

    public static String getDeleteStationNameInput() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return scanner.nextLine().trim();
    }
}
