package racingcar.common.exception;

public enum ErrorMessage {
    ILLEGAL_INPUT_VALUE("잘못된 입력값입니다."),
    CAN_NOT_NEGATIVE("음수를 입력할 수 없습니다.");
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
