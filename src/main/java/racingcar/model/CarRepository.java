package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CarRepository {

    private final List<Car> carList = new ArrayList<>();

    public CarRepository(Set<String> carNames) {
        for(String name : carNames) {
            carList.add(new Car(name));
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }
}
