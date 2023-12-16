package oncall.controller;

import oncall.domain.ScheduleDate;
import oncall.domain.Workers;
import oncall.view.input.InputView;
import oncall.view.output.OutputView;

import java.util.List;

public class WorkScheduleController {

    private final InputView inputView;
    private final OutputView outputView;

    public WorkScheduleController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        ScheduleDate scheduleDate = inputScheduleDate();
        Workers workers = inputWorkers();
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
