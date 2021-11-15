package controller;

import domain.interfaces.InputView;
import domain.interfaces.OutputView;
import domain.ProgressResultMessageCreator;
import domain.service.RacingCarService;
import view.ConsoleInputView;
import view.ConsoleOutputView;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;


public class GameController {
    private static final int CARNAME_MAXLENGTH = 5;
    private final InputView inputView = new ConsoleInputView();
    private final OutputView outputView = new ConsoleOutputView();
    private final ProgressResultMessageCreator progressResultMessageCreator = new ProgressResultMessageCreator();


    public void runRacingCarGame() {
        outputView.askCarNames();
        String carNames = getCarNames();
        outputView.askRepetitionNumber();
        int repetitionNumber = getRepetitionNumber();


        RacingCarService service = new RacingCarService(carNames);
        for (int i = 0; i < repetitionNumber; i++) {
            service.playOneGame();
            outputView.printMsg(progressResultMessageCreator.makeProgressMessage(service.getProgress()));
        }

        outputView.printMsg(progressResultMessageCreator.makeResultMessage(service.getWinnerNames()));
    }

    private int getRepetitionNumber() {
        int repetitionNumber;

        while (true) {
            try {
                repetitionNumber = inputView.getNumberInput();
                break;
            } catch (InputMismatchException e) {
                outputView.printMsg(e.getMessage());
                continue;
            }
        }

        return repetitionNumber;
    }

    private String getCarNames() {
        String carNamesInput = inputView.getInput();

        while (true) {
            try {
                validateCarNamesInput(carNamesInput);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printMsg(e.getMessage());
                carNamesInput = inputView.getInput();
            }
        }

        return carNamesInput;
    }

    private void validateCarNamesInput(String names) throws IllegalArgumentException {
        if (names.length() == 0 || names.equals("")) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        List<String> namesList = Arrays.stream(names.split(",")).collect(Collectors.toList());

        for (String name : namesList) {
            if ((name.length() > CARNAME_MAXLENGTH)) {
                throw new IllegalArgumentException("입력값의 길이가 5 이상이거나 공백을 포함하고 있습니다.");
            }
        }

    }

}
