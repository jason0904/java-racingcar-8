package racingcar.controller;

import racingcar.model.CarRepository;
import racingcar.model.RacingService;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarOutput;

public class RacingController {

    private final CarRepository carRepository;
    private final RacingService racingService;
    private final RacingCarInput racingCarInput = new RacingCarInput();
    private final RacingCarOutput racingCarOutput = new RacingCarOutput();
    private int round;

    public RacingController(CarRepository carRepository) {
        this.carRepository = carRepository;
        this.racingService = new RacingService(carRepository);
    }


    public void run() {
        runInit();
        runRaceRound();
        runFinalWinner();
    }

    public void runInit() {
        carRepository.addCarList(racingCarInput.InputCarNames());
        round = racingCarInput.InputPlayCount();
    }

    public void runRaceRound() {
        racingCarOutput.printGameResultMessage();
        for(int i = 0; i < round; i++) {
            racingService.runRaceRound();
            racingCarOutput.printGameResult(carRepository.getCarList());
        }
    }

    public void runFinalWinner() {
        racingCarOutput.printFinalWinner(racingService.getWinnersName());
    }





}
