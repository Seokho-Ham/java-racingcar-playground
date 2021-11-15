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
    private final InputView iv = new ConsoleInputView();
    private final OutputView ov = new ConsoleOutputView();
    private final ProgressResultMessageCreator progressResultMessageCreator = new ProgressResultMessageCreator();


    public void runRacingCarGame() {
        ov.askCarNames();
        String carNames = getCarNames();
        ov.askRepetitionNumber();
        int repetitionNumber = getRepetitionNumber();


        RacingCarService service = new RacingCarService(carNames);
        for (int i = 0; i < repetitionNumber; i++) {
            service.playOneGame();
            String progressMessage = progressResultMessageCreator.makeProgressMessage(service.getCars());
            ov.printMsg(progressMessage);
        }

        String gameResult = progressResultMessageCreator.makeResultMessage(service.getWinnerNames());
        ov.printMsg(gameResult);
    }

    private int getRepetitionNumber() {
        int repetitionNumber;
        while (true) {
            try {
                repetitionNumber = iv.getNumberInput();
                break;
            } catch (InputMismatchException e) {
                ov.printMsg(e.getMessage());
                continue;
            }
        }
        return repetitionNumber;
    }

    private String getCarNames() {
        String carNamesInput = iv.getInput();
        while (true) {
            try {
                validateCarNamesInput(carNamesInput);
                break;
            } catch (IllegalArgumentException e) {
                ov.printMsg(e.getMessage());
                carNamesInput = iv.getInput();
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
