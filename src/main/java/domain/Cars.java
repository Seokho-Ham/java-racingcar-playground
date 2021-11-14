package domain;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private RandomNumbers randomNumberCreator;
    private List<Car> cars;

    public Cars(CarNames names) {
        this.cars = names.getCarNames().stream().map(s->new Car(s)).collect(Collectors.toList());
        this.randomNumberCreator = new RandomNumbers();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void moveCars() {
        cars.stream().forEach(s->{
            int randomNumber = randomNumberCreator.makeRandomNumber();
            s.move(randomNumber);
        });
    }

    public List<String> findWinners(){
        int max = cars.stream().mapToInt(s->s.getPos()).max().orElseThrow(NoSuchElementException::new);
        return cars.stream().filter(s->s.getPos() == max).map(s->s.getCarName()).collect(Collectors.toList());
    }
}
