package domain;

public class Position {
    private int pos;

    public Position(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }
    public void movePos(){
        this.pos++;
    }
}
