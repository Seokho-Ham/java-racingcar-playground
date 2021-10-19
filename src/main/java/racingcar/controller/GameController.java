package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Splitter;
import racingcar.model.Trials;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private static final InputView inputController = new InputView();
    private static final OutputView outputController = new OutputView();

    public void run() {
        Cars cars;
        try{
             cars = new Cars(getCarNames());
        }catch(RuntimeException e){
            outputController.printException(e.getMessage());
            cars = new Cars(getCarNames());
        }
        int runTime = getRuntimes().getTrial();
        for (int i = 0; i < runTime; i++) {
            cars.moveCars();
            outputController.printCarsStatus(cars.getCars());
        }

        int maxDistance = cars.getCars().stream()
                .max(Comparator.comparing(s -> s.getMovedDistance()))
                .get().getMovedDistance();

        List<String> winners = cars.getCars().stream()
                .filter(s -> s.getMovedDistance() == maxDistance)
                .map(s -> s.getName())
                .collect(Collectors.toList());

        outputController.printResult(String.join(",", winners));

    }

    private List<String> getCarNames() {
        outputController.printStartMessage();
        List<String> result;

        try {
            result = Splitter.splitNames(inputController.getInput());
        } catch (RuntimeException e) {
            outputController.printException(e.getMessage());
            result = getCarNames();
        }

        return result;
    }

    private Trials getRuntimes() {
        outputController.printRunTimes();
        Trials trials;
        try {
            trials = new Trials(inputController.getInput());
        } catch (RuntimeException e) {
            outputController.printException(e.getMessage());
            trials = getRuntimes();
        }
        return trials;
    }
}
