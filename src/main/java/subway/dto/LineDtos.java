package subway.dto;

import subway.domain.LineRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LineDtos {

    List<LineDto> lineDtos;

    private LineDtos(LineRepository lineRepository) {
        lineDtos = lineRepository.getLines().stream().map(LineDto::of).collect(Collectors.toList());
    }

    public static LineDtos of(LineRepository lineRepository) {
        return new LineDtos(lineRepository);
    }

    public List<LineDto> getLineDtos() {
        return lineDtos;
    }
}
