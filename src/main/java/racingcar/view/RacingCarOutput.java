package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class RacingCarOutput {

    private final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private final String ROUND_RESULT_MESSAGE = "실행 결과";

    public void printFinalWinner(List<String> winnerNames) {
        System.out.println(FINAL_WINNER_MESSAGE + String.join(", ", winnerNames));
    }

    public void printGameResult(List<Car> result) {
        for(Car car : result) {
            System.out.println(car.getName() + " : " + printCarMove(car.getPosition()));
        }
        System.out.println();
    }

    public String printCarMove(int position) {
        return "-".repeat(position);
    }

    public void printGameResultMessage() {
        System.out.println(ROUND_RESULT_MESSAGE);
    }
}
