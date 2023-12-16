package oncall.domain;

import oncall.constant.DayOfWeek;
import oncall.constant.Month;

public class ScheduleDate {

    private final Month month;
    private final DayOfWeek startDay;

    public ScheduleDate(Month month, DayOfWeek startDay) {
        this.month = month;
        this.startDay = startDay;
    }

    public Month getMonth() {
        return month;
    }

    public DayOfWeek getStartDay() {
        return startDay;
    }
}
