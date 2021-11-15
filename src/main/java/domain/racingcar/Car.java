package domain.racingcar;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private final CarName carName;
    private Position movedDistance;

    public Car(CarName name) {
        this.carName = name;
        this.movedDistance = new Position();
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getCurrentPosition() {
        return movedDistance.getPosition();
    }

    public String getConvertedPosition() {
        return movedDistance.convertPosition();
    }

    public void move(int randomNumber) {
        if (randomNumber >= MINIMUM_NUMBER_TO_MOVE) {
            movedDistance.movePosition();
        }
    }

}
