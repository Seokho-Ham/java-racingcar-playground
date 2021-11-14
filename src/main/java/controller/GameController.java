package controller;

import domain.Cars;
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
    private final ProgressResultMessageCreator messageService = new ProgressResultMessageCreator();
    private int repetitionNumber;
    private List<String> carNames;

    public void run() {
        RacingCarService service = new RacingCarService(carNames);
        for (int i = 0; i < repetitionNumber; i++) {
            Cars cars = service.playOneGame();
            String progressMessage = messageService.makeProgressMessage(cars);
            ov.printMsg(progressMessage);
        }

        String gameResult = messageService.makeResultMessage(service.getWinnerNames());
        ov.printMsg(gameResult);
    }

    public void setInitialSetting(){
        ov.askCarNames();
        setCarNames();
        ov.askRepetitionNumber();
        setRepetitionNumber();
    }

    private void setRepetitionNumber(){
        while(true){
            try{
                repetitionNumber = iv.getNumberInput();
                break;
            }catch(InputMismatchException e){
                ov.printMsg(e.getMessage());
                continue;
            }
        }
    }

    private void setCarNames(){
        String carNamesInput = iv.getInput();
        while(true){
            try{
                validateCarNamesInput(carNamesInput);
                break;
            }catch(IllegalArgumentException e){
                ov.printMsg(e.getMessage());
                carNamesInput = iv.getInput();
            }
        }
        carNames =  Arrays.stream(carNamesInput.split(",")).collect(Collectors.toList());
    }



    private void validateCarNamesInput(String names) throws IllegalArgumentException{
        List<String> namesList = Arrays.stream(names.split(",")).collect(Collectors.toList());
        for (String name : namesList) {
            if ((name.length() > CARNAME_MAXLENGTH  || name.contains(" ")) || name.length() == 0) {
                throw new IllegalArgumentException("입력값의 길이가 5 이상이거나 공백을 포함하고 있습니다.");
            }
        }

    }

}
