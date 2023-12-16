package oncall.dto;

import oncall.constant.DayOfWeek;
import oncall.constant.Month;
import oncall.domain.ScheduleDate;

public record InputScheduleDateDto(int month, String dayOfWeek) {

    public ScheduleDate toScheduleDate() {
        return new ScheduleDate(
                Month.convertToMonth(month),
                DayOfWeek.convertValueToDayOfWeek(dayOfWeek)
        );
    }
}
