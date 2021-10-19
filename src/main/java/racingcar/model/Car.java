package racingcar.model;

public class Car {
    private String name;
    private int distance = 0;

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
        return number >= 4;
    }

    public void move(int num) {
        if (decideToMove(num)) {
            distance++;
        }

    }
}
