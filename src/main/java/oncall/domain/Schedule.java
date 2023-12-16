package oncall.domain;

import oncall.constant.DayOfWeek;
import oncall.constant.Month;
import oncall.constant.WeekendDay;

public class Schedule {

    private final Month month;
    private final int day;
    private final DayOfWeek dayOfWeek;
    private final Worker worker;

    public Schedule(Month month, int day, DayOfWeek dayOfWeek, Worker worker) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.worker = worker;
    }

    public int getMonthValue() {
        return month.getNumberValue();
    }

    public int getDay() {
        return day;
    }

    public String getDayOfWeekValue() {
        return dayOfWeek.getDisplayName();
    }

    public String getWorkerName() {
        return worker.getName();
    }

    public boolean isWeekend() {
        return WeekendDay.isWeekend(month, day);
    }
}
