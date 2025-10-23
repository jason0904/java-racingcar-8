package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    private final CarRepository carRepository;
    private final int MINIMUM_MOVE_NUMBER = 4;

    public RacingService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void runRaceRound() {
        carRepository.getCarList()
                .stream()
                .filter(car -> Randoms.pickNumberInRange(0,9) >= MINIMUM_MOVE_NUMBER)
                .forEach(Car::move);
    }

    public List<String> getWinnersName() {
        List<Car> carList = carRepository.getCarList();

        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
