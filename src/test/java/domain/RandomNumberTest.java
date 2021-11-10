package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    @DisplayName("0~9로 이루어진 랜덤넘버 리스트 반환 여부")
    void makeRandomNumbers() {
        RandomNumbers numbers = new RandomNumbers(4);
        numbers.getRandomNumbers().stream().forEach(s->{
            assertThat(s).isGreaterThanOrEqualTo(0);
            assertThat(s).isLessThanOrEqualTo(9);
        });
    }
}
