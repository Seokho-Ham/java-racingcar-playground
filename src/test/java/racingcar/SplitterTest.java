package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Splitter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitterTest {
    @Test
    @DisplayName(",를 기준으로 올바르게 분리하는가?")
    void splitByComma(){
        List<String> nameList1 = Splitter.splitNames("user1,user2,user3");
        for(int i=0; i<nameList1.size();i++){
            assertThat(nameList1.get(i).equals("user"+(i+1))).isTrue();
        }

        List<String> nameList2 = Splitter.splitNames("user1,user2");
        for(int i=0; i<nameList2.size();i++){
            assertThat(nameList2.get(i).equals("user"+(i+1))).isTrue();
        }
    }

    @Test
    @DisplayName("구분자가 없을 경우")
    void noDelimiter(){
        assertThatThrownBy(()->Splitter.splitNames("user1 user2 user3")).isInstanceOf(RuntimeException.class).hasMessage("구분자가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("구분자가 쉼표가 아닐 경우")
    void delimiterIsNotComma(){
        assertThatThrownBy(()->Splitter.splitNames("user1;user2;user3")).isInstanceOf(RuntimeException.class).hasMessage("구분자가 올바르지 않습니다.");
    }

}
