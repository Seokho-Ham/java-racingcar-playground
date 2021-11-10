package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("Car이 이동하는지 여부 테스트")
    void move() {
        Car car1 = new Car(new CarName("coco"));
        car1.move();
        assertThat(car1.getPosition()).isEqualTo(1);
        car1.move();
        car1.move();
        assertThat(car1.getPosition()).isEqualTo(3);
    }

}
