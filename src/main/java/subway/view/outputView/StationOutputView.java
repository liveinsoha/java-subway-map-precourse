package subway.view.outputView;

public class StationOutputView {

    public  static void printErrorMessage(String message){
        System.out.println(message);
    }

    public static void printStationScreen(){
        System.out.println("## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기");
    }
}
