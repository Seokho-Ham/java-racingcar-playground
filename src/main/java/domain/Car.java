package domain;

public class Car {
    private static final int MOVE_POINT = 4;
    private final CarName carName;
    private Position pos;

    public Car(CarName name) {
        this.carName = name;
        this.pos = new Position(0);
    }

    public String getCarName() {
        return carName.getName();
    }

    public String getConvertedPos(){
        return pos.convertPos();
    }

    public void move(int randomNumber) {
        if(randomNumber >= MOVE_POINT){
            pos.movePos();
        }
    }


    public int getPos() {
        return pos.getPos();
    }
}
