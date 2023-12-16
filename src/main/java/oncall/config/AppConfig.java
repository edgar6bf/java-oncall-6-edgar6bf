package oncall.config;

import oncall.controller.WorkScheduleController;
import oncall.domain.ScheduleGenerator;
import oncall.repository.ScheduleRepository;
import oncall.view.input.InputView;
import oncall.view.output.OutputView;

public class AppConfig {

    public static WorkScheduleController config() {
        return gameController();
    }

    private static WorkScheduleController gameController() {
        return new WorkScheduleController(inputView(), outputView(), scheduleGenerator());
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static ScheduleGenerator scheduleGenerator() {
        return new ScheduleGenerator(scheduleRepository());
    }

    private static ScheduleRepository scheduleRepository() {
        return new ScheduleRepository();
    }
}
