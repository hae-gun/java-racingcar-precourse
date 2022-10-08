package racingcar.car;

import org.junit.jupiter.api.*;
import racingcar.common.exception.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init(){
        cars = new Cars();
    }

    @Test
    @DisplayName("자동차 리스트 생성")
    void createCars(){
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("자동차르 추가하면 내부 리스트에 저장")
    void addCars(){
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");

        cars.addCars(car1);
        cars.addCars(car2);
        cars.addCars(car3);

        assertThat(cars.carList()).contains(car1, car2, car3);
    }

    @Test
    @DisplayName("동일한 객체가 리스트에 들어오면 에러발생")
    void canNotAddSameCar(){
        Car car1 = new Car("car1");

        cars.addCars(car1);

        assertThatThrownBy(() -> {
            cars.addCars(car1);
        }).hasMessageContaining(ErrorMessage.CAN_NOT_ADD_SAME_CAR.getMessage());
    }

    @Test
    @DisplayName("리스트 출력시 복사해서 가져온다.")
    void getListIsCopyObject(){
        Car car = new Car("car1");
        Car car2 = new Car("car2");
        cars.addCars(car);

        cars.carList().add(car2);

        assertThat(cars.carList().size()).isEqualTo(1);
    }
}