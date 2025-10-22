package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RaceService {

    private final CarRepository carRepository;

    public RaceService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void startRace(int round) {
        for(int i = 0; i < round; i++) {
            runRaceRound();
        }
    }

    public void runRaceRound() {
        for(Car car : carRepository.getCarList()) {
            if(Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

    public List<String> getWinnersName() {
        int maxRace = -1;
        List<String> winners = new ArrayList<>();
        for(Car car : carRepository.getCarList()) {
            if(car.getPosition() >= maxRace) {
                maxRace = car.getPosition();
                winners.add(car.getName());
            }
            else {
               winners.clear();
            }
        }
        return winners;
    }

}
