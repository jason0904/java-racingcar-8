package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CarRepository {

    private final List<Car> carList = new ArrayList<>();

    public void addCarList(Set<String> carNames) {
        for(String name : carNames) {
            carList.add(new Car(name));
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public void updateCarMove(String carName) {
        for(Car car : carList) {
            if(car.getName().equals(carName)) {
                car.move();
            }
        }
    }

}
