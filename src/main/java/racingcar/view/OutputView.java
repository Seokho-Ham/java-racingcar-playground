package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    private static final String moveSign = "-";

    public void printStartMessage() {
        System.out.println("자동차의 이름들을 입력해주세요");
        System.out.println("쉼표를 구분자로 입력해주세요.");
    }

    public void printRunTimes() {
        System.out.print("게임을 진행할 횟수를 입력해주세요. : ");
    }

    public void printCarsStatus(List<Car> cars) {
        cars.stream().forEach(s -> {
            printCarStatus(s.getName(), s.getMovedDistance());
        });
        System.out.println();
    }

    private void printCarStatus(String name, int distance) {
        String result = "";
        for (int i = 0; i < distance; i++) {
            result += moveSign;
        }
        System.out.println(name + " : " + result);
    }

    public void printResult(String result) {
        System.out.println(result + "님이 우승했습니다");
    }

    public void printException(String message){
        System.out.println(message);
    }
}
