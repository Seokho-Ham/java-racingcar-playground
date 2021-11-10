package view;

import domain.interfaces.OutputView;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printMsg(String msg){
        System.out.println(msg);
    }

    @Override
    public void printProgress(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printResult(String msg) {
        System.out.println(msg);
    }

}
