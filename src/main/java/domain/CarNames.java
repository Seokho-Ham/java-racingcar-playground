package domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
    private final List<CarName> carNames;

    public CarNames(List<String> carNames) {
        this.carNames = carNames.stream().map(s -> new CarName(s)).collect(Collectors.toList());
    }

    public List<CarName> getCarNames() {
        return carNames;
    }
}
