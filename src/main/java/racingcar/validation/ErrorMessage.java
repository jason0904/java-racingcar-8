package racingcar.validation;

public enum ErrorMessage {
    STRING_BLANK_ERROR("빈 문자열을 입력하셨습니다."),
    STRING_END_COMMA("문자열의 마지막이 쉼표입니다."),
    CARNAME_DUPLICATE_ERROR("자동차 이름이 겹칩니다."),
    CARNAME_BLANK_ERROR("자동차 이름이 공백입니다."),
    COUNT_NOT_NUMBER_ERROR("반복 횟수 입력이 숫자가 아닙니다."),
    COUNT_IS_ZERO_ERROR("반복 횟수 입력은 0이 들어갈 수 없습니다."),
    COUNT_NOT_INTEGER_ERROR("반복 횟수 입력이 정수가 아닙니다."),
    COUNT_NOT_POSITIVE_ERROR("반복 횟수 입력이 양수가 아닙니다.");



    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
