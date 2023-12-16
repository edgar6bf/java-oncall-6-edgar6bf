package oncall.domain;

import oncall.constant.DayOfWeek;
import oncall.constant.Month;
import oncall.constant.WeekendDay;
import oncall.repository.ScheduleRepository;

import java.util.List;

import static oncall.constant.DayOfWeek.*;

public class ScheduleGenerator {

    private static final int START_DATE = 1;
    private static final int TOTAL_DAY_OF_WEEK_SEQUENCE = 7;

    private final ScheduleRepository scheduleRepository;

    private int lastWeekdaySequence = 0;
    private int lastWeekendSequence = 0;

    public ScheduleGenerator(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> generateSchedule(ScheduleDate scheduleDate, Workers workers) {
        int totalDays = scheduleDate.getMonth().getDays();
        int startDayOfWeekSequence = scheduleDate.getStartDay().getSequence() - 1;
        for (int day = START_DATE; day <= totalDays; day++) {
            int dayOfWeekSequence = (startDayOfWeekSequence + day) % TOTAL_DAY_OF_WEEK_SEQUENCE;
            DayOfWeek targetDayOfWeek = convertSequenceToDayOfWeek(dayOfWeekSequence);
            Worker findWorker = findWorker(workers, scheduleDate.getMonth(), day, targetDayOfWeek);
            scheduleRepository.save(new Schedule(scheduleDate.getMonth(), day, targetDayOfWeek, findWorker));
        }

        return scheduleRepository.getAll();
    }

    private Worker findWorker(Workers workers, Month month, int day, DayOfWeek dayOfWeek) {
        boolean isWeekend = checkWeekend(month, day, dayOfWeek);

        // 주말 근무
        if (isWeekend) {
            return workers.findWorkers(lastWeekendSequence++, day, true);
        }

        // 평일 근무
        return workers.findWorkers(lastWeekdaySequence++, day, false);
    }

    private boolean checkWeekend(Month month, int day, DayOfWeek weekendDay) {
        return weekendDay == SATURDAY || weekendDay == SUNDAY || WeekendDay.isWeekend(month, day);
    }
}
