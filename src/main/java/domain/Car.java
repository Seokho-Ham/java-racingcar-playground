package domain;

public class Car {

    private final CarName carName;
    private Position pos;

    public Car(CarName name) {
        this.carName = name;
        this.pos = new Position(0);
    }

    public String getCarName() {
        return carName.getName();
    }

    public void move() {
        pos.movePos();
    }

    public int getPosition() {
        return pos.getPos();
    }
}
