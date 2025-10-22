package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validation.ErrorMessage;
import racingcar.validation.RacingCarInputValidation;

public class RacingCarInputTest {

    @Test
    @DisplayName("자동차 이름이 겹칠 때 예외 테스트")
    public void carNameDuplicateTest() {
        String inputString = "pobi,pobi";
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarInputValidation.validateCarNameDuplicate(java.util.List.of(inputString.split(",")));
        });
    }

    @Test
    @DisplayName("문자열이 빈 공백이 들어왔을 때 예외 테스트")
    public void stringBlankTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarInputValidation.validateBlankString("");
        });
    }

    @Test
    @DisplayName("문자열의 마지막이 쉼표일 때 예외테스트")
    public void stringEndCommaTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarInputValidation.validateStringLastComma("pobi,");
        });
    }

    @Test
    @DisplayName("자동차 이름이 공백일때 예외 테스트")
    public void carNameBlankTest() {
        String string = "pobi, ,a";
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarInputValidation.validateCarNameBlank(java.util.List.of(string.split(",")));
        });
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 아닐경우 테스트")
    public void countIsNotNumberTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarInputValidation.validateCountIsNumber("a");
        });
    }

    @Test
    @DisplayName("시도할 횟수가 실수일경우 테스트")
    public void countIsNotIntegerTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarInputValidation.vaildateCountIsInteger("1.5");
        });
    }

    @Test
    @DisplayName("시도할 횟수가 0일때 테스트")
    public void countIsZeroTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            RacingCarInputValidation.validateCountIsPositive(0);
        });
        assertEquals(ErrorMessage.COUNT_IS_ZERO_ERROR.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수가 음수일때 테스트")
    public void countIsNegativeTest(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            RacingCarInputValidation.validateCountIsPositive(-1);
        });
        assertEquals(ErrorMessage.COUNT_NOT_POSITIVE_ERROR.getMessage(), exception.getMessage());
    }


}
