package racingcar.car;

import racingcar.car.value.CarName;
import racingcar.car.value.Position;

public class Car {
    private CarName carName;
    private Position position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }
}
