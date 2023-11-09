package subway.view.inputView;

import java.util.Scanner;

public class CourseInputView {
    static final Scanner scanner = new Scanner(System.in);

    public static String getUserChoiceNumber() {
        System.out.println("## 구간 관리 화면\n" +
                "1. 구간 등록\n" +
                "2. 구간 삭제\n" +
                "B. 돌아가기");
        return scanner.nextLine().trim();
    }

    public static String getAddCourseLineName(){
        System.out.println("## 노선을 입력하세요.");
        return scanner.nextLine().trim();
    }

    public static String getAddCourseStationName(){
        System.out.println("## 역이름을 입력하세요.");
        return scanner.nextLine().trim();
    }

    public static String getAddCourseIndex(){
        System.out.println("## 순서를 입력하세요.");
        return scanner.nextLine().trim();
    }

    public static String getDeleteCourseLineName(){
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        return scanner.nextLine().trim();
    }

    public static String getDeleteCourseStationName(){
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        return scanner.nextLine().trim();
    }
}
