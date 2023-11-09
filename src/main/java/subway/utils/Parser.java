package subway.utils;

public class Parser {

    public static int parseToInt(String userInput) {
        try {
           return Integer.parseInt(userInput.trim());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다");
        }
    }
}
