package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private RandomNumbers randomNumberCreator;
    private List<Car> cars;

    public Cars(List<CarName> names) {
        this.cars = names.stream().map(s->new Car(s)).collect(Collectors.toList());
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
        return cars.stream().filter(s->s.getPos()==cars.stream().map(car->car.getPos()).max(Comparator.comparing(pos->pos)).get()).map(s->s.getCarName()).collect(Collectors.toList());
    }
}
