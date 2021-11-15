package domain.service;

import domain.racingcar.Car;
import domain.racingcar.CarName;
import domain.racingcar.Cars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class RacingCarService {
    private final Cars cars;

    public RacingCarService(String carNames) throws IllegalArgumentException {
        List<CarName> carNameList = Arrays.stream(carNames.split(",")).map(s -> new CarName(s)).collect(Collectors.toList());
        this.cars = new Cars(carNameList);
    }

    public void playOneGame() {
        cars.moveCars();
    }

    public Map<String, String> getProgress(){
        Map<String, String> gameProgress = new HashMap<>();

        for(Car car : cars.getCars()){
            gameProgress.put(car.getCarName(), car.getConvertedPosition());
        }

        return gameProgress;
    }

    public List<String> getWinnerNames(){
        return cars.findWinners();
    }
}
