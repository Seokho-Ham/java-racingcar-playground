package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    @DisplayName("0~9로 이루어진 랜덤넘버 리스트 반환 여부")
    void makeRandomNumbers() {
        RandomNumbers numbers = new RandomNumbers();
        int randomNumber = numbers.makeRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0);
        assertThat(randomNumber).isLessThanOrEqualTo(9);

    }
}
