package view;

import domain.interfaces.InputView;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private final static Scanner sc = new Scanner(System.in);

    @Override
    public String getInput() {
        return sc.nextLine();
    }


}
