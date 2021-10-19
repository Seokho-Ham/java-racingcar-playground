package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("input이 4이상일때만 자동차의 이동 거리를 1늘리는 메소드 테스트")
    void moveCar(){
        Car car = new Car("coco");
        car.move(9);
        assertThat(car.getMovedDistance()).isEqualTo(1);
        car.move(4);
        car.move(6);
        car.move(0);
        assertThat(car.getMovedDistance()).isEqualTo(3);

    }
}
