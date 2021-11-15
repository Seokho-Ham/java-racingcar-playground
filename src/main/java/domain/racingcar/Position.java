package domain.racingcar;

public class Position {
    private static final String MOVE_EXPRESSION = "-";
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void movePosition() {
        this.position++;
    }

    public String convertPosition() {
        String convertedPosition = "";
        for (int i = 0; i < position; i++) {
            convertedPosition += MOVE_EXPRESSION;
        }
        return convertedPosition;
    }
}
