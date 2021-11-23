package ui.view;

import ui.interfaces.InputView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private final static Scanner sc = new Scanner(System.in);

    @Override
    public String getInput() {
        return sc.nextLine();
    }

    @Override
    public int getNumberInput() throws InputMismatchException {
        int numberInput;

        try {
            numberInput = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            throw new InputMismatchException("숫자를 입력해주세요.");
        }

        return numberInput;
    }
}
