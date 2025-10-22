package racingcar.view;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.RacingCarInputValidation;

public class RacingCarInput {

    private final String INPUT_CARNAME_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_COUNT_STRING = "시도할 횟수는 몇 회인가요?";

    public Set<String> InputCarNames() {
        String inputString;
        List<String> carNames;

        System.out.println(INPUT_CARNAME_STRING);
        inputString = Console.readLine();
        RacingCarInputValidation.validateBlankString(inputString);
        RacingCarInputValidation.validateStringLastComma(inputString);

        carNames = List.of(inputString.split(","));
        RacingCarInputValidation.validateCarNameBlank(carNames);
        RacingCarInputValidation.validateCarNameDuplicate(carNames);
        RacingCarInputValidation.validateCarNameLengthLimit(carNames);

        return Collections.unmodifiableSet(Set.copyOf(carNames));
    }

    public int InputPlayCount() {
        String inputString;
        int inputCount;
        System.out.println(INPUT_COUNT_STRING);
        inputString = Console.readLine();
        RacingCarInputValidation.validateBlankString(inputString);
        RacingCarInputValidation.validateCountIsNumber(inputString);
        RacingCarInputValidation.vaildateCountIsInteger(inputString);

        inputCount = Integer.parseInt(inputString);
        RacingCarInputValidation.validateCountIsPositive(inputCount);

        return inputCount;
    }



}
