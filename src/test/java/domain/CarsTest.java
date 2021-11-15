package domain;

import domain.racingcar.Car;
import domain.racingcar.CarName;
import domain.racingcar.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private static Cars cars;

    @BeforeEach
    void beforeEach() {
        List<CarName> carNames = Arrays.asList("coco,dodo,bobo").stream().map(s->new CarName(s)).collect(Collectors.toList());
        cars = new Cars(carNames);
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
        cars.moveCars();
        cars.getCars().stream().forEach(s->{
            assertThat(s.getPos()).isEqualTo(1);
        });
    }
}
