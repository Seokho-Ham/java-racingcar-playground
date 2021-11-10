package domain;

public class Car {

    private final CarName carName;
    private Position pos;
    private String strPos;

    public Car(CarName name) {
        this.carName = name;
        this.pos = new Position(0);
        this.strPos = "";
    }

    public String getCarName() {
        return carName.getName();
    }

    public String getStrPos(){
        return strPos;
    }

    public void move() {
        pos.movePos();
        strPos+="-";
    }


    public int getPos() {
        return pos.getPos();
    }
}
