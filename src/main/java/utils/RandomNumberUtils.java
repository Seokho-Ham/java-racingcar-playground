package utils;

import java.util.Random;

public class RandomNumberUtils {
    private static final int MAX = 9;

    public int makeRandomNumber() {
        return new Random().nextInt(MAX);
    }
}
