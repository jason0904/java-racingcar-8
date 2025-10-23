package racingcar.model;

import racingcar.validation.PlayCountValiation;

public class PlayCount {

    private final int playCount;

    public PlayCount(String playCount) {

        PlayCountValiation.validateCountIsNumber(playCount);
        PlayCountValiation.validateCountIsInteger(playCount);
        PlayCountValiation.validateCountIsPositive(playCount);

        this.playCount = Integer.parseInt(playCount);
    }

    public int getPlayCount() {
        return playCount;
    }

}
