package ui.controller;

import domain.gameservice.GameService;
import ui.interfaces.InputView;
import ui.interfaces.OutputView;
import ui.view.ConsoleInputView;
import ui.view.ConsoleOutputView;

import java.util.InputMismatchException;

public class GameController {
    private static final InputView inputView = new ConsoleInputView();
    private static final OutputView outputView = new ConsoleOutputView();

    public void run(){
        GameService service = new GameService();
        outputView.askCarNames();
        while(true){
            try {
                service.setCarNames(inputView.getInput());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
        outputView.askRepeatTimes();
        while(true){
            try {
                service.setRepeatTimes(inputView.getNumberInput());
                break;
            } catch (InputMismatchException e) {
                outputView.printException(e.getMessage());
            }
        }


        service.runGame();
        outputView.printProgress(service.getGameProgress());
        outputView.printResult(service.getWinnersNames());
    }
}
