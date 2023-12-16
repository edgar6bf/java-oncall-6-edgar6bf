package oncall.domain;

import oncall.constant.DayOfWeek;
import oncall.constant.Month;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScheduleDateTest {

    @DisplayName("유효한 월과 시작 요일을 입력하면 정상적으로 객체가 생성된다.")
    @Test
    void inputValidMonthAndDay() throws Exception {
        // Given
        int validMonth = 5;
        String validStartWeekOfDay = "월";

        // When
        Month month = Month.convertToMonth(validMonth);
        DayOfWeek dayOfWeek = DayOfWeek.convertValueToDayOfWeek(validStartWeekOfDay);
        ScheduleDate scheduleDate = new ScheduleDate(month, dayOfWeek);

        // Then
        Assertions.assertThat(scheduleDate).isNotNull();
    }
}
