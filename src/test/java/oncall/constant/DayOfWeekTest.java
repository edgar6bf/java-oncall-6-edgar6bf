package oncall.constant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DayOfWeekTest {

    @DisplayName("유효한 요일 이름을 입력하면 정상적으로 객체가 반환된다.")
    @MethodSource("dayOfWeekNames")
    @ParameterizedTest
    void inputValidDayOfWeekName(String inputValue, DayOfWeek expected) throws Exception {
        // When
        DayOfWeek dayOfWeek = DayOfWeek.convertValueToDayOfWeek(inputValue);

        // Then
        Assertions.assertThat(dayOfWeek).isEqualTo(expected);
    }

    private static Stream<Arguments> dayOfWeekNames() {
        return Stream.of(
                Arguments.of("월", DayOfWeek.MONDAY),
                Arguments.of("화", DayOfWeek.TUESDAY),
                Arguments.of("수", DayOfWeek.WEDNESDAY),
                Arguments.of("목", DayOfWeek.THURSDAY),
                Arguments.of("금", DayOfWeek.FRIDAY),
                Arguments.of("토", DayOfWeek.SATURDAY),
                Arguments.of("일", DayOfWeek.SUNDAY)
        );
    }

    @DisplayName("유효하지 않은 요일 이름을 입력하면 예외가 발생한다.")
    @Test
    void inputInvalidDayOfWeekName() throws Exception {
        // Given
        String invalidDayOfWeekName = "양성욱 요일";

        // When & Then
        Assertions.assertThatThrownBy(() -> DayOfWeek.convertValueToDayOfWeek(invalidDayOfWeekName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 요일입니다. 다시 입력해주세요.");
    }

    @DisplayName("유효한 요일 시퀀스를 입력하면 정상적으로 객체가 반환된다.")
    @MethodSource("dayOfWeeSequences")
    @ParameterizedTest
    void inputValidDayOfWeekSequence(int inputValue, DayOfWeek expected) throws Exception {
        // When
        DayOfWeek dayOfWeek = DayOfWeek.convertSequenceToDayOfWeek(inputValue);

        // Then
        Assertions.assertThat(dayOfWeek).isEqualTo(expected);
    }

    private static Stream<Arguments> dayOfWeeSequences() {
        return Stream.of(
                Arguments.of(0, DayOfWeek.MONDAY),
                Arguments.of(1, DayOfWeek.TUESDAY),
                Arguments.of(2, DayOfWeek.WEDNESDAY),
                Arguments.of(3, DayOfWeek.THURSDAY),
                Arguments.of(4, DayOfWeek.FRIDAY),
                Arguments.of(5, DayOfWeek.SATURDAY),
                Arguments.of(6, DayOfWeek.SUNDAY)
        );
    }

    @DisplayName("유효하지 않은 요일 시퀀스를 입력하면 예외가 발생한다.")
    @Test
    void inputInvalidDayOfWeekSequence() throws Exception {
        // Given
        int invalidDayOfWeekSequence = 9;

        // When & Then
        Assertions.assertThatThrownBy(() -> DayOfWeek.convertSequenceToDayOfWeek(invalidDayOfWeekSequence))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 요일 시퀀스입니다.");
    }
}
