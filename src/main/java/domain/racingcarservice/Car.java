package domain.racingcarservice;

public class Car {
    private static final int CARNAME_MAXLENGTH = 5;
    private static final String POSITION_EXPRESSION = "-";
    private final CarName carName;
    private final Position position;

    public Car(String carName) throws IllegalArgumentException {
        validateCarName(carName);
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public void move(boolean isMove) {
        if (isMove) {
            this.position.movePosition();
        }
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getPositionInExpression() {
        StringBuilder currentPosition = new StringBuilder("");
        for (int i = 0; i < this.position.getPosition(); i++) {
            currentPosition.append(POSITION_EXPRESSION);
        }
        return currentPosition.toString();
    }

    private void validateCarName(String name) throws IllegalArgumentException {
        if (name.length() > CARNAME_MAXLENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5자 이하여야 합니다.");
        }
        if (name.length() < 1) {
            throw new IllegalArgumentException("이름은 최소 1자 이상이어야 합니다.");
        }
    }
}
