package racingcar.model;

import java.util.List;

public class CarNames {

    private List<String> carNames;

    public CarNames(List<String> names) throws RuntimeException {
        if(validateName(names)){
            throw new RuntimeException("이름의 길이가 5를 넘어갑니다.");
        }
        carNames = names;
    }

    public List<String> getCarNames(){
        return carNames;
    }

    private boolean validateName(List<String> names){
        return names.stream().anyMatch(s->s.length()>5);
    }
}
