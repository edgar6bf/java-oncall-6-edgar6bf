package oncall;

import oncall.config.AppConfig;
import oncall.controller.WorkScheduleController;

public class Application {
    public static void main(String[] args) {
        WorkScheduleController workScheduleController = AppConfig.config();
        workScheduleController.run();
    }
}
