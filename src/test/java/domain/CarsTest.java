package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private static Cars cars;

    @BeforeEach
    void beforeEach() {
        CarNames names = new CarNames(Arrays.asList("coco,dodo,bobo"));
        cars = new Cars(names);
    }

    @Test
    @DisplayName("입력된 이름들로 Car들을 만드는 테스트")
    void makeCarList() {
        cars.getCars().stream().forEach(s->{
            assertThat(s).isInstanceOf(Car.class);
        });
    }

    @Test
    @DisplayName("Car들을 이동시키는 테스트")
    void moveCars() {
        cars.moveCars(new RandomNumbers(4,5,6));
        cars.getCars().stream().forEach(s->{
            assertThat(s.getPosition()).isEqualTo(1);
        });
    }
}
