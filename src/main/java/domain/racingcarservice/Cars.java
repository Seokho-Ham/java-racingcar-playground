package domain.racingcarservice;

import domain.interfaces.MovingStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) throws IllegalArgumentException {
        List<String> carNameList = carNameSplitter(carNames);
        this.cars = carNameList.stream().map(s -> new Car(s)).collect(Collectors.toList());
    }

    public void startRace(MovingStrategy strategy) {
        for (Car car : this.cars) {
            car.move(strategy.isMove());
        }
    }

    private List<String> carNameSplitter(String carNames) {
        return Arrays.stream(carNames.split(",")).collect(Collectors.toList());
    }

    public Map<String, String> getCurrentPositions(){
        Map<String, String> currentPositions = new HashMap<>();
        cars.stream().forEach(s->{
            currentPositions.put(s.getCarName(), s.getPositionInExpression());
        });
        return currentPositions;
    }

    public List<String> findWinners() {
        return this.cars.stream()
                .filter(s -> s.getPosition() == cars.stream().map(car -> car.getPosition()).max(Comparator.comparing(pos -> pos)).get())
                .map(s -> s.getCarName())
                .collect(Collectors.toList());
    }
}
