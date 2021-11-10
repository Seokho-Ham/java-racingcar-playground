package domain;


import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(CarNames names) {
        this.cars = names.getNames().stream().map(s->new Car(s)).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }


    public void moveCars(RandomNumbers randomNumbers) {
        for(int i=0; i<this.cars.size(); i++){
            if(randomNumbers.getRandomNumbers().get(i) >=4){
                this.cars.get(i).move();
            }
        }
    }
}
