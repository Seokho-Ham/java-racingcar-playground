package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpliterTest {
    @Test
    @DisplayName("디폴트 구분자 형식의 문자열 split 테스트")
    void checkDefaultDelimiter(){
        assertThat(Spliter.splitInput("1,2,3")).isEqualTo(Arrays.asList(1,2,3));
    }
    @Test
    @DisplayName("커스텀 구분자 형식의 문자열 split 테스트")
    void checkCustomDelimiter(){
        assertThat(Spliter.splitInput("//;\n1;2;3")).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    @DisplayName("Runtime Exception 테스트")
    void exceptionTest() throws Exception {
        assertThatThrownBy(()->Spliter.splitInput("//;\n-1;2;3")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()->Spliter.splitInput("//;\na;2;3")).isInstanceOf(RuntimeException.class);
    }
}
