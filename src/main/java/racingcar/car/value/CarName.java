package racingcar.car.value;

import racingcar.common.exception.ErrorMessage;

public class CarName {
    private final int MAX_NAME_LENGTH = 5;
    private String name;

    public CarName(String name) {
        validation(name);
        this.name = name;
    }

    public String value() {
        return name;
    }

    private void validation(String name){
        if(name.length()<=0 || name.length()>MAX_NAME_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
