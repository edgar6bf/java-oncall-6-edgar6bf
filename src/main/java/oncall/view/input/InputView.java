package oncall.view.input;

import camp.nextstep.edu.missionutils.Console;
import oncall.dto.InputScheduleDateDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_DELIMITER = ",";

    public InputScheduleDateDto inputScheduleDate() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        List<String> inputValues = splitInputValue(Console.readLine(), INPUT_DELIMITER);

        return new InputScheduleDateDto(parseNumber(inputValues.get(0)), inputValues.get(1));
    }

    private List<String> splitInputValue(String inputValue, String delimiter) {
        return Arrays.stream(inputValue.split(delimiter))
                .collect(Collectors.toList());
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 정수가 아닙니다.");
        }
    }
}
