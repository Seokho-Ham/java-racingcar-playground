package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumbers {
    private final int MAX = 9;
    private List<Integer> numbers;

    public RandomNumbers(int carCounts) {
        this.numbers = new ArrayList<>(carCounts);

        for (int i = 0; i < carCounts; i++) {
            this.numbers.add(makeRandomNumber());
        }
    }

    public RandomNumbers(int num1, int num2, int num3) {
        this.numbers = Arrays.asList(num1, num2, num3);
    }

    public List<Integer> getRandomNumbers() {
        return numbers;
    }

    private int makeRandomNumber() {
        return new Random().nextInt(MAX);
    }



}
