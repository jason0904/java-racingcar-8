package racingcar.validation;

public class PlayCountValiation {

    public static void validateCountIsNumber(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_NOT_NUMBER_ERROR.getMessage());
        }
    }

    public static void validateCountIsInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_NOT_INTEGER_ERROR.getMessage());
        }
    }

    public static void validateCountIsPositive(String inputCount) {
        if(Integer.parseInt(inputCount) == 0) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_IS_ZERO_ERROR.getMessage());
        }
        if (Integer.parseInt(inputCount) < 0) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_NOT_POSITIVE_ERROR.getMessage());
        }
    }

}
