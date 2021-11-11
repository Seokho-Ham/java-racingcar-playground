package controller;

import domain.Car;
import domain.Cars;
import domain.interfaces.InputView;
import domain.interfaces.OutputView;
import domain.service.RacingCarService;
import view.ConsoleInputView;
import view.ConsoleOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class GameController {
    private final InputView iv = new ConsoleInputView();
    private final OutputView ov = new ConsoleOutputView();

    public void run() {

        ov.printMsg("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesInput = iv.getInput();
        while (!validateCarNamesInput(carNamesInput)) {
            ov.printMsg("입력값의 길이가 5 이상이거나 공백을 포함하고 있습니다.");
            carNamesInput = iv.getInput();
        }

        ov.printMsg("시도할 회수는 몇회인가요?");
        String countsInput = iv.getInput();
        while(!validateNumberInput(countsInput)){
            ov.printMsg("숫자를 입력해주세요");
            countsInput = iv.getInput();;
        }

        int counts = Integer.parseInt(countsInput);
        List<String> carNames =  Arrays.stream(carNamesInput.split(",")).collect(Collectors.toList());

        RacingCarService service = new RacingCarService(carNames);
        for (int i = 0; i < counts; i++) {
            Cars result = service.playOneGame();
            ov.printProgress(makeResult(result));
        }

        ov.printResult(service.findWinners() + "가 최종 우승했습니다.");
    }

    private String makeResult(Cars cars) {
        String result = "";
        for (Car car : cars.getCars()) {
            result += car.getCarName() + ":" + car.getStrPos() + "\n";
        }
        return result;
    }


    private boolean validateNumberInput(String num) {
        if (num.length() == 0) {
            return false;
        }
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean validateCarNamesInput(String names) {
        List<String> namesList = Arrays.stream(names.split(",")).collect(Collectors.toList());
        for (String name : namesList) {
            if ((name.length() > 5 || name.contains(" ")) || name.length() == 0) {
                return false;
            }
        }
        return true;
    }

}
