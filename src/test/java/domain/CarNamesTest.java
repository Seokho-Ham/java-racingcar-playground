package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNamesTest {
    @Test
    @DisplayName("CarName 객체들을 만드는 테스트")
    void splitNames() {
        CarNames names = new CarNames("coco,dodo,bobo");
        names.getNames().stream().forEach(s->{
            assertThat(s).isInstanceOf(CarName.class);
        });
    }

    @Test
    @DisplayName("name의 길이가 5이하거나 공백이 있을 경우 익셉션 테스트")
    void validateName() {
        assertThatThrownBy(() -> {
            new CarNames("coco,dodosd,bobo");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new CarNames("");
        }).isInstanceOf(IllegalArgumentException.class);

    }


}
