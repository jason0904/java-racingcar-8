package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {

    private final List<Car> carList = new ArrayList<>();

    public void addCarList(List<String> carNames) {
        carNames.forEach(name -> carList.add(new Car(name)));
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public void updateCarMove(String carName) {
        carList.stream()
                .filter(car -> car.getName().equals(carName))
                .findFirst()
                .ifPresent(Car::move);
    }

}
