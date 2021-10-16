package racingcar;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    private static final String DELIMITER = ",";

    public static List<String> splitNames(String names){
        List<String> result = Arrays.asList(names.split(DELIMITER));
        if(result.size()<2){
            throw new RuntimeException("구분자가 올바르지 않습니다.");
        }
        return result;
    }
}
