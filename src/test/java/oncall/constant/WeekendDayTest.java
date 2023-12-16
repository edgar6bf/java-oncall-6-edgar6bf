package oncall.constant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendDayTest {

    @DisplayName("주말에 해당하는 월, 날짜를 입력하면 true를 반환한다.")
    @Test
    void returnTrue() throws Exception {
        // Given
        Month month = Month.MAY;
        int day = 5;

        // When
        boolean isWeekend = WeekendDay.isWeekend(month, day);

        // Then
        Assertions.assertThat(isWeekend).isTrue();
    }

    @DisplayName("주말에 해당하지 않는 월, 날짜를 입력하면 false를 반환한다.")
    @Test
    void returnFalse() throws Exception {
        // Given
        Month month = Month.JULY;
        int day = 5;

        // When
        boolean isWeekend = WeekendDay.isWeekend(month, day);

        // Then
        Assertions.assertThat(isWeekend).isFalse();
    }
}
