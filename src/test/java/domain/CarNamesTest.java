package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {
    @Test
    @DisplayName("CarName 객체들을 만드는 테스트")
    void splitNames() {
        CarNames names = new CarNames(Arrays.asList("coco,dodo,bobo"));
        names.getCarNames().stream().forEach(s->{
            assertThat(s).isInstanceOf(CarName.class);
        });
    }



}
