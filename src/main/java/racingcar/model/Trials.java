package racingcar.model;

public class Trials {
    private int trial;

    public Trials(String runtime) throws RuntimeException{
        try{
            trial = Integer.parseInt(runtime);
        }catch (RuntimeException e){
            throw new RuntimeException("숫자를 입력해주세요.");
        }

    }

    public int getTrial(){
        return trial;
    }

}
