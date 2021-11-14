package domain;

public class Position {
    private static final String HYPHEN = "-";
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

    public String convertPos(){
        String convertedPos = "";
        for(int i=0; i<pos; i++){
            convertedPos+= HYPHEN;
        }
        return convertedPos;
    }
}
