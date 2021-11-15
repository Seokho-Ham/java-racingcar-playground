package domain;

import java.util.List;
import java.util.Map;

public class ProgressResultMessageCreator {
    public String makeProgressMessage(Map<String,String> singleGameProgress){
        String progressMessage = "";

        for(Map.Entry<String, String> carProgress : singleGameProgress.entrySet()){
            progressMessage += carProgress.getKey() + " : " + carProgress.getValue() + "\n";
        }

        return progressMessage;
    }

    public String makeResultMessage(List<String> winners){
        return String.join(",",winners) + "가 최종 우승했습니다.";
    }
}
