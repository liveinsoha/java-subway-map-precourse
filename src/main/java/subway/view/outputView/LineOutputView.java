package subway.view.outputView;

import subway.dto.LineDtos;

public class LineOutputView {

    public  static void printLinesInfo(LineDtos lineDtos){
        lineDtos.getLineDtos().forEach(lineDto ->System.out.println("[INFO] " + lineDto.getName()));
    }
}
