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
                new Line("2호선", Station.of("교대역"), Station.of("역삼역"), Arrays.asList(Station.of("강남역"))),
                new Line("3호선", Station.of("교대역"), Station.of("매봉역"), Arrays.asList(Station.of("남부터미널역"), Station.of("양재역"))),
                new Line("신분당선", Station.of("강남역"), Station.of("양재시민의숲역"), Arrays.asList(Station.of("양재역"))));
        lines.addAll(initLines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void validateDuplicate(String newLineName) {
        if (lines.stream().anyMatch(line -> line.getName().equals(newLineName))) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다");
        }
    }

    public void deleteLineByName(String name) {
        validateExist(name);
        Line removeLine = lines.stream().filter(line -> line.getName().equals(name)).findFirst().get();

        removeLine.decreaseInLineCountForStations();
         lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    private void validateExist(String name) {
        if (lines.stream().noneMatch(line -> line.getName().equals(name))) {
            throw new IllegalArgumentException("[ERROR] 해당 라인은 존재하지 않습니다");
        }
    }

}
