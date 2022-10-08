package racingcar.car.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exception.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("자동차는 이름을 가져야 한다.")
    void carMustHaveName(){
        assertThatThrownBy(() -> {
            new CarName("");
        }).hasMessageContaining(ErrorMessage.ILLEGAL_INPUT_VALUE.getMessage());
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하만 가능하다.")
    void nameLengthOverFive(){
        assertThatThrownBy(() -> {
            new CarName("123456");
        }).hasMessageContaining(ErrorMessage.ILLEGAL_INPUT_VALUE.getMessage());
    }
}