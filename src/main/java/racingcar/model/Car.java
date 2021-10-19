package racingcar.model;

public class Car {
    private String name;
    private int distance = 0;
    private static final int MOVE_NUMBER = 4;

    public Car(String s) {
        name = s;
    }

    public int getMovedDistance() {
        return distance;
    }
    public String getName(){
        return name;
    }

    private boolean decideToMove(int number) {
        return number >= MOVE_NUMBER;
    }

    public void move(int num) {
        if (decideToMove(num)) {
            distance++;
        }

    }
}
