package racingcar.view;

import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import racingcar.model.PlayCount;
import racingcar.validation.RacingCarInputValidation;

public class RacingCarInput {

    private final String INPUT_CARNAME_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_COUNT_STRING = "시도할 횟수는 몇 회인가요?";

    public List<String> InputCarNames() {
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

        return Collections.unmodifiableList(carNames);
    }

    public PlayCount InputPlayCount() {
        String inputString;
        System.out.println(INPUT_COUNT_STRING);
        inputString = Console.readLine();
        RacingCarInputValidation.validateBlankString(inputString);

        return new PlayCount(inputString);
    }



}
