package racingcar.validation;

public class RacingCarInputValidation {

    public static void validateBlankString(String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.STRING_BLANK_ERROR.getMessage());
        }
    }

    public static void validateStringLastComma(String inputString) {
        if(inputString.lastIndexOf(",") == inputString.length()-1) {
            throw new IllegalArgumentException(ErrorMessage.STRING_END_COMMA.getMessage());
        }
    }

}




