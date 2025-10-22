package racingcar;

import java.util.Set;
import racingcar.controller.RacingController;
import racingcar.model.CarRepository;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarOutput;

public class Application {
    public static void main(String[] args) {

        CarRepository carRepository = new CarRepository();
        RacingController racingController = new RacingController(carRepository);

        racingController.run();
    }
}
