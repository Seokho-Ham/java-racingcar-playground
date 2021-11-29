package domain.gameservice;

import domain.racingcarservice.RacingCarService;

public class GameService {
    private String gameProgress = "";
    private int repeatTimes;
    private RacingCarService racingCarService;

    public void setCarNames(String carNames) throws IllegalArgumentException {
        this.racingCarService = new RacingCarService(carNames);
    }

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    public void runGame() {
        for (int i = 0; i < this.repeatTimes; i++) {
            racingCarService.startSingleRace();
            gameProgress += racingCarService.getProgressByString() + "\n";
        }
    }

    public String getGameProgress() {
        return this.gameProgress;
    }

    public String getWinnersNames() {
        return racingCarService.getWinners();
    }
}
