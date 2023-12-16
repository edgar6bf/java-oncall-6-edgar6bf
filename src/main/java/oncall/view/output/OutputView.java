package oncall.view.output;

import oncall.dto.ScheduleDto;

import java.util.List;

public class OutputView {

    public void printSchedules(List<ScheduleDto> schedules) {
        System.out.println();
        schedules.forEach(this::printSchedule);
    }

    private void printSchedule(ScheduleDto schedule) {
        String message = schedule.month() + "월 " + schedule.day() + "일 " + schedule.dayOfWeek();

        if (schedule.isWeekend()) {
            message += "(휴일)";
        }
        message += " " + schedule.worker();

        System.out.println(message);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
