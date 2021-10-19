package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public String getInput() {
        return sc.nextLine();
    }
}
