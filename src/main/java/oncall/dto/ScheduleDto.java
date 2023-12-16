package oncall.dto;

import oncall.domain.Schedule;

public record ScheduleDto(int month, int day, String dayOfWeek, String worker, boolean isWeekend) {

    public static ScheduleDto from(Schedule schedule) {
        return new ScheduleDto(
                schedule.getMonthValue(),
                schedule.getDay(),
                schedule.getDayOfWeekValue(),
                schedule.getWorkerName(),
                schedule.isWeekend()
        );
    }
}
