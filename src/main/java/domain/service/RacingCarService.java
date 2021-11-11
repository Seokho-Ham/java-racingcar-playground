package domain.service;

import domain.Car;
import domain.CarNames;
import domain.Cars;
import domain.RandomNumbers;

import java.util.ArrayList;
import java.util.List;


public class RacingCarService {
    private final Cars cars;
    private final int carsCount;

    public RacingCarService(List<String> names) throws IllegalArgumentException {
        CarNames carNames = new CarNames(names);
        this.cars = new Cars(carNames);
        this.carsCount = cars.getCountOfCars();
    }

    public Cars playOneGame() {
        cars.moveCars(new RandomNumbers(carsCount));
        return cars;
    }

    public String findWinners(){
        int max = 0;
        for(Car car : cars.getCars()){
            if(max < car.getPos()){
                max = car.getPos();
            }
        }
        List<String> winners = new ArrayList<>();

        for(Car car : cars.getCars()){
            if(car.getPos() == max){
                winners.add(car.getCarName());
            }
        }

        return String.join(",",winners);
    }


}
