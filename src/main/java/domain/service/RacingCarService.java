package domain.service;

import domain.CarName;
import domain.Cars;

import java.util.Arrays;
import java.util.List;
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

    public Cars getCars(){
        return this.cars;
    }

    public List<String> getWinnerNames(){
        return cars.findWinners();
    }
}
