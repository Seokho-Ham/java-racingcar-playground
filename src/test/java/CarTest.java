import domain.racingcarservice.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 5자 이하면 Car 객체가 올바르게 생성되는지 테스트")
    void carNameValidate() {
        Car car = new Car("coco");
        assertThat(car.getCarName()).isEqualTo("coco");
    }

    @Test
    @DisplayName("이름이 5자 이상이거나 빈문자열일 경우 익셉션 발생시키는 테스트")
    void carNameException() {
        assertThatThrownBy(()->{new Car("cocococo");}).isInstanceOf(IllegalArgumentException.class).hasMessage("이름의 길이는 5자 이하여야 합니다.");
        assertThatThrownBy(()->{new Car("");}).isInstanceOf(IllegalArgumentException.class).hasMessage("이름은 최소 1자 이상이어야 합니다.");
    }

    @Test
    @DisplayName("입력되는 값에 따라 이동 여부 테스트")
    void move() {
        Car car = new Car("coco");
        car.move(true);
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("이동 거리를 '-' 로 표현하는 테스트 ")
    void name() {
        Car car = new Car("coco");
        car.move(true);
        car.move(true);
        assertThat(car.getPositionInExpression().equals("--")).isTrue();
    }
}
