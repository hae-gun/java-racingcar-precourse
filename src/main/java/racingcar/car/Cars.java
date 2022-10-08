package racingcar.car;

import racingcar.common.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public void addCars(Car car){
        validation(car);
        this.cars.add(car);
    }

    public List<Car> carList(){
        return new ArrayList<>(cars);
    }

    private void validation(Car car){
        if(cars.contains(car)){
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_ADD_SAME_CAR.getMessage());
        }
    }
}
