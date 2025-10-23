package racingcar.validation;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CarListValidation {

    public static void validateCarNameDuplicate(List<String> carNames) {
        Set<String> duplicate = new LinkedHashSet<>();
        Set<String> unique = new LinkedHashSet<>();

        for (String name : carNames) {
            if (!unique.add(name)) {
                duplicate.add(name);
            }
        }

        if (!duplicate.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.CARNAME_DUPLICATE_ERROR + "겹치는 이름 : " + String.join(", ", duplicate));
        }
    }

    public static void validateCarNameBlank(List<String> carNames) {
        for (String name : carNames) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.CARNAME_BLANK_ERROR.getMessage());
            }
        }
    }

    public static void validateCarNameLengthLimit(List<String> carNames) {
        for (String name : carNames) {
            if(name.length() >= 6) {
                throw new IllegalArgumentException(ErrorMessage.CARNAME_LIMIT_ERROR.getMessage());
            }
        }
    }

}
