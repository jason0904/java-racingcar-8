package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingServiceTest {

    @Test
    @DisplayName("움직임 정상작동 테스트")
    public void moveCarTest(){
        CarRepository carRepository = new CarRepository();
        carRepository.addCarList(List.of("name"));
        Car car = carRepository.getCarList().get(0);

        assertEquals(0, car.getPosition());

        carRepository.updateCarMove("name");
        car = carRepository.getCarList().get(0);

        assertEquals(1, car.getPosition());

    }

    @Test
    @DisplayName("우승자 확인 정상작동 테스트")
    public void winnerCheckTest(){
        CarRepository carRepository = new CarRepository();
        carRepository.addCarList(List.of("name", "name2"));
        carRepository.updateCarMove("name");
        RacingService racingService = new RacingService(carRepository);
        List<String> winners = racingService.getWinnersName();

        assertEquals(1, winners.size());
        assertEquals("name", winners.getFirst());

    }



}
