package subway.dto;

import subway.domain.Line;

public class LineDto {

    String name;

    private LineDto(String name){
        this.name = name;
    }

    public static LineDto of(Line line){
        return new LineDto(line.getName());
    }

    public String getName() {
        return name;
    }
}
