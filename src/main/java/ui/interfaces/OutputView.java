package ui.interfaces;

public interface OutputView {
    void askCarNames();
    void askRepeatTimes();
    void printException(String message);
    void printProgress(String progress);
    void printResult(String names);
}