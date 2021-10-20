package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> names) throws RuntimeException{
        if (validateName(names)) {
            throw new RuntimeException("이름의 길이가 5를 넘어갑니다.");
        }
        cars = names.stream().map(s -> new Car(s)).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    private boolean validateName(List<String> names) {
        return names.stream().anyMatch(s -> s.length() > 5);
    }

    public void moveCars() {
        RandomNumber random = new RandomNumber();
        cars.stream().forEach(s -> s.move(random.makeRandomNum()));
    }


}
