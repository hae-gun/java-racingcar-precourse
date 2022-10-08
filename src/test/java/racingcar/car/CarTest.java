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

    @Test
    @DisplayName("move 함수를 통해 포지션 이동")
    void moveCar(){
        Car car = new Car("car");
        car.move();
        assertThat(car.position()).isEqualTo(1);
    }

    @Test
    @DisplayName("생성자 입력값으로 이름 지정")
    void getNames(){
        final String name = "myCar";
        Car car = new Car(name);
        assertThat(car.name()).isEqualTo(name);
    }

    @Test
    @DisplayName("carName 이 같으면 같은 객체로 인식")
    void sameNameIsSameObject(){
        final String name = "name";
        Car car1 = new Car(name);
        Car car2 = new Car(name);

        assertThat(car1).isEqualTo(car2);
    }
}