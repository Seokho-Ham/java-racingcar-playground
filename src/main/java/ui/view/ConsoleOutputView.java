package ui.view;

import ui.interfaces.OutputView;

public class ConsoleOutputView implements OutputView {
    private static final String CARNAMES_QUESTION = "자동차 이름을 입력해주세요.(,로 분리해서 입력해주세요)";
    private static final String REPEAT_TIMES_QUESTION = "반복 횟수를 입력해주세요.";
    private static final String WINNER_MESSAGE = " 님이 최종 우승하셨습니다.";

    @Override
    public void askCarNames() {
        System.out.println(CARNAMES_QUESTION);
    }

    @Override
    public void askRepeatTimes() {
        System.out.println(REPEAT_TIMES_QUESTION);
    }

    @Override
    public void printException(String message) {
        System.out.println(message);
    }

    @Override
    public void printProgress(String progress) {
        System.out.println(progress);
    }

    @Override
    public void printResult(String names) {
        System.out.println(names + WINNER_MESSAGE);
    }
}
