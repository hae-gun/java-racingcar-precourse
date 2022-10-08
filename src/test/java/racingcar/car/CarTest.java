package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @Test
    @DisplayName("자동차 객체 생성")
    void makeCar(){
        Car car = new Car("car1");
        assertThat(car).isNotNull();
    }
}