package oncall.repository;

import oncall.domain.Schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScheduleRepository {

    private final List<Schedule> schedules;

    public ScheduleRepository() {
        this.schedules = new ArrayList<>();
    }

    public void save(Schedule schedule) {
        schedules.add(schedule);
    }

    public List<Schedule> getAll() {
        return Collections.unmodifiableList(schedules);
    }
}
