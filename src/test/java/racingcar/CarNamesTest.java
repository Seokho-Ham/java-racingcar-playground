package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarNames;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNamesTest {
    @Test
    @DisplayName("이름의 길이를 올바르게 검증하는가?")
    void validateNameLength() {
        CarNames names = new CarNames(Arrays.asList("user1", "user2", "user3"));
        assertThat(names.getCarNames().stream().anyMatch(s -> s.length() > 5)).isFalse();
    }

    @Test
    @DisplayName("이름의 길이가 5를 넘어갈 경우 Exception 발생")
    void nameLengthException() throws Exception {
        assertThatThrownBy(() -> new CarNames(Arrays.asList("sdsadasdsa", "23ds", "sdsa")))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름의 길이가 5를 넘어갑니다.");
    }
}
