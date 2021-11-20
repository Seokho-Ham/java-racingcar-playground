package domain.racingcar;

import utils.RandomNumberUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private RandomNumberUtils randomNumberCreator;
    private List<Car> cars;

    public Cars(List<CarName> names) {
        this.cars = names.stream().map(s -> new Car(s)).collect(Collectors.toList());
        this.randomNumberCreator = new RandomNumberUtils();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void moveCars() {
        cars.stream().forEach(s -> {
            s.move(randomNumberCreator.makeRandomNumber());
        });
    }

    public List<String> findWinners() {
        return cars.stream()
                .filter(s -> s.getCurrentPosition() == cars.stream().map(car -> car.getCurrentPosition()).max(Comparator.comparing(pos -> pos)).get())
                .map(s -> s.getCarName())
                .collect(Collectors.toList());
    }
}
