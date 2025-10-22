package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.CarRepository;

public class Application {
    public static void main(String[] args) {

        CarRepository carRepository = new CarRepository();
        RacingController racingController = new RacingController(carRepository);

        racingController.run();
    }
}
