package domain;

import java.util.Random;

public class RandomNumbers {
    private final int MAX = 9;

    public int makeRandomNumber() {
        return new Random().nextInt(MAX);
    }
}
