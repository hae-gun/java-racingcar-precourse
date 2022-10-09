package racingcar.race;

import org.junit.jupiter.api.*;
import racingcar.car.Car;
import racingcar.common.factory.RandomFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceTest {


    private static RandomFactory factoryReturnUnder4;
    private static RandomFactory factoryReturnOver4;

    @BeforeAll
    public static void setMockFactory(){
        factoryReturnUnder4 = new RandomFactory() {
            @Override
            public int makeRandomNumber() {
                return 3;
            }
        };

        factoryReturnOver4 = new RandomFactory() {
            @Override
            public int makeRandomNumber() {
                return 5;
            }
        };
    }

    @Test
    @DisplayName("레이스에 Car 참가 테스트")
    void carJoinRace(){
        Race race = new Race(factoryReturnOver4);
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        race.join(car1);
        race.join(car2);
        race.join(car3);
        assertThat(race.joinUserList()).containsExactly("car1","car2","car3");
    }

    @Test
    @DisplayName("레이스 참가 자동차 위치 확인")
    void getCarPositions(){
        Race race = new Race(factoryReturnOver4);
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        race.join(car1);
        race.join(car2);
        race.join(car3);
        assertThat(race.carPositions()).containsExactly(0, 0, 0);
    }

    @Test
    @DisplayName("랜덤수 숫자 4 이상일때 자동차 전진")
    void moveCarIfRandomNumberOver4(){
        Race race = new Race(factoryReturnOver4);
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        race.join(car1);
        race.join(car2);

        assertThat(race.carPositions()).containsExactly(0, 0);
        race.moveCars();
        assertThat(race.carPositions()).containsExactly(1, 1);
    }

    @Test
    @DisplayName("랜덤수 숫자 4 미만일때 자동차 전진")
    void moveCarIfRandomNumberUnder4(){
        Race race = new Race(factoryReturnUnder4);
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        race.join(car1);
        race.join(car2);

        assertThat(race.carPositions()).containsExactly(0, 0);
        race.moveCars();
        assertThat(race.carPositions()).containsExactly(0, 0);
    }
}