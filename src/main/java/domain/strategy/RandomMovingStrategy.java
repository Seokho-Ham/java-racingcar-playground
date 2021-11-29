package domain.strategy;

import domain.interfaces.MovingStrategy;
import utils.RandomUtil;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    @Override
    public boolean isMove() {
        return RandomUtil.makeRandomNumber() >= MINIMUM_NUMBER_TO_MOVE;
    }
}
