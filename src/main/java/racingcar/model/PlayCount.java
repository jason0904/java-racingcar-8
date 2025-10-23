package racingcar.model;

import racingcar.validation.PlayCountValidation;

public class PlayCount {

    private final int playCount;

    public PlayCount(String playCount) {

        PlayCountValidation.validateCountIsNumber(playCount);
        PlayCountValidation.validateCountIsInteger(playCount);
        PlayCountValidation.validateCountIsPositive(playCount);

        this.playCount = Integer.parseInt(playCount);
    }

    public int getPlayCount() {
        return playCount;
    }

}
