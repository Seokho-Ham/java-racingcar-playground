package racingcar.model;

import java.util.Random;

public class RandomNumber {
    private static final Random random = new Random();
    private static final int RANGE = 9;

    public int makeRandomNum(){
        return random.nextInt(RANGE);
    }
}
