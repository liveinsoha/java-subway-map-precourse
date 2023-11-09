package subway.view.inputView;

import java.util.Scanner;

public class LineInputView {

    static final Scanner scanner = new Scanner(System.in);

    public static String getUserChoiceNumber() {
        System.out.println("## 노선 관리 화면\n" +
                "1. 노선 등록\n" +
                "2. 노선 삭제\n" +
                "3. 노선 조회\n" +
                "B. 돌아가기");
        return scanner.nextLine().trim();
    }

    public static String getAddLineNameInput() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return scanner.nextLine().trim();
    }

    public static String getUpperEndStationName() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getBelowEndStationName() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }
}
