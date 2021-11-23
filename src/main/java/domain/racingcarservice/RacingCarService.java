package domain.racingcarservice;

import domain.interfaces.MovingStrategy;
import domain.strategy.RandomMovingStrategy;

import java.util.Map;


public class RacingCarService {
    private final Cars cars;

    public RacingCarService(String carNames) throws IllegalArgumentException {
        this.cars = new Cars(carNames);
    }

    public void startSingleRace() {
        MovingStrategy strategy = new RandomMovingStrategy();
        this.cars.startRace(strategy);
    }

    public String getProgressByString() {
        String progress = "";
        for (Map.Entry<String, String> carProgress : cars.getCurrentPositions().entrySet()) {
            progress += carProgress.getKey() + " : " + carProgress.getValue() + "\n";
        }
        return progress;
    }


    public String getWinners() {
        return String.join(",", this.cars.findWinners());
    }
}
