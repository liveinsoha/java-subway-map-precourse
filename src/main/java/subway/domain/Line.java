package subway.domain;

public class Line {
    private String name;
    private Station upperEndStation;
    private Station belowEndStation;


    public Line(String name, Station upperEndStation, Station belowEndStation) {
        this.name = name;
        validateLineNameLength(name);
        this.upperEndStation = upperEndStation;
        this.belowEndStation = belowEndStation;
    }

    private void validateLineNameLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 노선 이름은 2글자 이상");
        }
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
