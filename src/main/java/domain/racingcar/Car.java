package domain.racingcar;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private final CarName carName;
    private Position pos;

    public Car(CarName name) {
        this.carName = name;
        this.pos = new Position();
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getCurrentPosition() {
        return pos.getPosition();
    }

    public String getConvertedPosition() {
        return pos.convertPosition();
    }

    public void move(int randomNumber) {
        if (randomNumber >= MINIMUM_NUMBER_TO_MOVE) {
            pos.movePos();
        }
    }

}
