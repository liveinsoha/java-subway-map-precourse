package subway.domain;

import java.util.*;

public class LineRepository {
    private static final LineRepository instance = new LineRepository();
    private static final List<Line> lines = new ArrayList<>();

    private LineRepository() {
    }

    public static LineRepository getInstance() {
        return instance;
    }

    static {
        List<Line> initLines = Arrays.asList(
                new Line("2호선", Station.of("교대역"), Station.of("역삼역")),
                new Line("3호선", Station.of("교대역"), Station.of("매봉역")),
                new Line("신분당선", Station.of("강남역"), Station.of("양재시민의숲역")));
        lines.addAll(initLines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void validateDuplicate(String newLineName) {
        if(lines.stream().anyMatch(line -> line.getName().equals(newLineName))){
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다");
        }
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
