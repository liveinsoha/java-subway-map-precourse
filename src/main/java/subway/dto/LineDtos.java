package subway.dto;

import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LineDtos {

    List<LineDto> lineDtos;

    private LineDtos(List<Line> lines) {
        lineDtos = lines.stream().map(LineDto::of).collect(Collectors.toList());
    }

    public static LineDtos of(List<Line> lines) {
        return new LineDtos(lines);
    }

    public List<LineDto> getLineDtos() {
        return lineDtos;
    }
}
