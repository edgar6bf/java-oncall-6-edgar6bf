package oncall.constant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MonthTest {

    @DisplayName("유효한 월 정수 값을 입력하면 정상적으로 객체가 반환된다.")
    @MethodSource("monthNumberValues")
    @ParameterizedTest
    void inputValidMonthNumberValue(int inputValue, Month expected) throws Exception {
        // When
        Month month = Month.convertToMonth(inputValue);

        // Then
        Assertions.assertThat(month).isEqualTo(expected);
    }

    private static Stream<Arguments> monthNumberValues() {
        return Stream.of(
                Arguments.of(1, Month.JANUARY),
                Arguments.of(2, Month.FEBRUARY),
                Arguments.of(3, Month.MARCH),
                Arguments.of(4, Month.APRIL),
                Arguments.of(5, Month.MAY),
                Arguments.of(6, Month.JUNE),
                Arguments.of(7, Month.JULY),
                Arguments.of(8, Month.AUGUST),
                Arguments.of(9, Month.SEPTEMBER),
                Arguments.of(10, Month.OCTOBER),
                Arguments.of(11, Month.NOVEMBER),
                Arguments.of(12, Month.DECEMBER)
        );
    }

    @DisplayName("유효하지 않은 월 정수 값을 입력하면 예외가 발생한다.")
    @Test
    void inputInvalidMonthNumberValue() throws Exception {
        // Given
        int invalidMonthNumberValue = 13;

        // When & Then
        Assertions.assertThatThrownBy(() -> Month.convertToMonth(invalidMonthNumberValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 월 입력입니다. 다시 입력해주세요.");
    }
}
