package subway.domain;

import java.util.Objects;

public class Station {
    private static final StationRepository stationRepository = StationRepository.getInstance();

    private final String name;
    private int inLineCount = 0;

    public Station(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static Station of(String name){
        return stationRepository.getStations().stream().filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getName() {
        return name;
    }

    public void validateNameLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 이름 길이는 2글자 이상");
        }
    }

    public void increaseInLineCount() {
        inLineCount++;
    }

    public int getInLineCount() {
        return inLineCount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Station that = (Station) object;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

}
