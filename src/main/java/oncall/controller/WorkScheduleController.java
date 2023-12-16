package oncall.controller;

import oncall.domain.ScheduleDate;
import oncall.domain.ScheduleGenerator;
import oncall.domain.Workers;
import oncall.dto.ScheduleDto;
import oncall.view.input.InputView;
import oncall.view.output.OutputView;

import java.util.List;

public class WorkScheduleController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ScheduleGenerator scheduleGenerator;

    public WorkScheduleController(InputView inputView, OutputView outputView, ScheduleGenerator scheduleGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.scheduleGenerator = scheduleGenerator;
    }

    public void run() {
        ScheduleDate scheduleDate = inputScheduleDate();
        Workers workers = inputWorkers();
        List<ScheduleDto> schedules = scheduleGenerator.generateSchedule(scheduleDate, workers)
                .stream()
                .map(ScheduleDto::from)
                .toList();

        outputView.printSchedules(schedules);
    }

    private ScheduleDate inputScheduleDate() {
        try {
            return inputView.inputScheduleDate().toScheduleDate();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());

            return inputScheduleDate();
        }
    }

    private Workers inputWorkers() {
        try {
            List<String> weekdayWorkers = inputView.inputWeekdayWorkers();
            List<String> weekendWorkers = inputView.inputWeekendWorkers();

            return new Workers(weekdayWorkers, weekendWorkers);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());

            return inputWorkers();
        }
    }
}
