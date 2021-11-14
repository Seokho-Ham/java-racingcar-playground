package domain.service;


import domain.CarNames;
import domain.Cars;

import java.util.List;


public class RacingCarService {
    private final Cars cars;

    public RacingCarService(List<String> names) throws IllegalArgumentException {
        CarNames carNames = new CarNames(names);
        this.cars = new Cars(carNames);
    }

    public Cars playOneGame() {
        cars.moveCars();
        return cars;
    }

    public List<String> getWinnerNames(){
        return cars.findWinners();
    }
}
