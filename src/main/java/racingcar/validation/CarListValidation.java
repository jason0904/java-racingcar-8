package racingcar.validation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CarListValidation {

    public static void validateCarNameDuplicate(List<String> carNames) {
        Set<String> duplicateCarName = carNames.stream()
                .collect(Collectors.groupingBy(name -> name, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(duplicateCarCount -> duplicateCarCount.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        if(!duplicateCarName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CARNAME_DUPLICATE_ERROR.getMessage() + "\n겹치는 이름 : "
            + String.join(", ", duplicateCarName));
        }
    }

    public static void validateCarNameBlank(List<String> carNames) {
        carNames.stream()
                .filter(String::isBlank)
                .findFirst()
                .ifPresent(err -> {throw new IllegalArgumentException(ErrorMessage.CARNAME_BLANK_ERROR.getMessage());
                });
    }

    public static void validateCarNameLengthLimit(List<String> carNames) {
        List<String> CarNamesOverLengthLimit = carNames.stream()
                .filter(name -> name.length() > CarNameMaxLength.MAX_LENGTH)
                .toList();

        if(!CarNamesOverLengthLimit.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CARNAME_LIMIT_ERROR.getMessage() + "\n" 
            + Integer.toString(CarNameMaxLength.MAX_LENGTH) + "자 이상인 자동차 이름 : "
            + String.join(", ", CarNamesOverLengthLimit));
        }

    }

}
