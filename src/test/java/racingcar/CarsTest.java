package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("Car로 구성된 리스트를 가진 객체를 올바르게 생성하는지 테스트")
    void makeCars(){
        List<String> names = Arrays.asList("pobi","coco","dodo");
        List<Car> cars = new Cars(names).getCars();

        for(Car car : cars){
            assertThat(car).isInstanceOf(Car.class);
        }
    }

    @Test
    @DisplayName("이름의 길이가 5를 넘어갈 경우 Exception 발생")
    void nameLengthException() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("sdsadasdsa", "23ds", "sdsa")))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름의 길이가 5를 넘어갑니다.");
    }





}
