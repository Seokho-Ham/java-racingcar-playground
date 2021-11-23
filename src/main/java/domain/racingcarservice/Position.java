package domain.racingcarservice;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public void movePosition() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }


}
