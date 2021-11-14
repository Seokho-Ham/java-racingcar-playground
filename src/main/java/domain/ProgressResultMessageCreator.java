package domain;

import java.util.List;

public class ProgressResultMessageCreator {
    public String makeProgressMessage(Cars cars){
        String progressMessage = "";

        for(Car car : cars.getCars()){
            String progress = car.getConvertedPos();
            progressMessage += car.getCarName() + " :" + progress + "\n";
        }

        return progressMessage;
    }

    public String makeResultMessage(List<String> winners){
        return String.join(",",winners) + "가 최종 우승했습니다.";
    }
}
