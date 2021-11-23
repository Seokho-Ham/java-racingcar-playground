package utils;

import java.util.Random;

public class RandomUtil {
    private static final int MAX_RANGE = 9;

    public static int makeRandomNumber() {
        return new Random().nextInt(MAX_RANGE);
    }
}
