package subway.view.inputView;

import java.util.Scanner;

public class MainInputView {

    static final Scanner scanner = new Scanner(System.in);

    public static String getUserChoiceNumber() {
        System.out.println("## 메인 화면\n" +
                "1. 역 관리\n" +
                "2. 노선 관리\n" +
                "3. 구간 관리\n" +
                "4. 지하철 노선도 출력\n" +
                "Q. 종료");
        return scanner.nextLine().trim();
    }
}
