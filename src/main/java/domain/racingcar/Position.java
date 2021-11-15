package domain.racingcar;

public class Position {
    private static final String MOVED_DISTANCE = "-";
    private int pos = 0;

    public int getPosition() {
        return pos;
    }

    public void movePos() {
        this.pos++;
    }

    public String convertPosition() {
        String convertedPos = "";
        for (int i = 0; i < pos; i++) {
            convertedPos += MOVED_DISTANCE;
        }
        return convertedPos;
    }
}
