package view;

import domain.interfaces.OutputView;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printMsg(String msg){
        System.out.println(msg);
    }
    @Override
    public void askCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }
    @Override
    public void askRepetitionNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
