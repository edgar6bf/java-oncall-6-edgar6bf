package oncall.domain;

import java.util.*;

public class Workers {

    private static final int ALLOWED_MINIMUM_WORKER_COUNT = 5;
    private static final int ALLOWED_MAXIMUM_WORKER_COUNT = 35;

    private final List<Worker> weekdayWorkers;
    private final List<Worker> weekendWorkers;

    public Workers(List<String> weekdayWorkers, List<String> weekendWorkers) {
        validateWorkersCountEqual(weekdayWorkers, weekendWorkers);
        validateWorkersDuplicated(weekdayWorkers);
        validateWorkersCount(weekdayWorkers, weekendWorkers);
        this.weekdayWorkers = convertToWorkerObject(weekdayWorkers);
        this.weekendWorkers = convertToWorkerObject(weekendWorkers);
    }

    private void validateWorkersCountEqual(List<String> weekdayWorkers, List<String> weekendWorkers) {
        if (Collections.disjoint(weekdayWorkers, weekendWorkers)) {
            throw new IllegalArgumentException("모든 근무자는 평일, 휴일 각 1회씩 비상 근무에 참가해야합니다. 다시 입력하세요.");
        }
    }

    private void validateWorkersDuplicated(List<String> weekdayWorkers) {
        int workerSize = weekdayWorkers.size();
        Set<String> testSet = new HashSet<>(weekdayWorkers);

        if (testSet.size() != workerSize) {
            throw new IllegalArgumentException("비상 근무자를 중복 입력할 수 없습니다. 다시 입력하세요.");
        }
    }

    private void validateWorkersCount(List<String> weekdayWorkers, List<String> weekendWorkers) {
        if (weekdayWorkers.size() < ALLOWED_MINIMUM_WORKER_COUNT || weekendWorkers.size() > ALLOWED_MAXIMUM_WORKER_COUNT) {
            throw new IllegalArgumentException("비상 근무자 배치는 5 ~ 35명만 가능합니다. 다시 입력하세요.");
        }
    }

    private List<Worker> convertToWorkerObject(List<String> workers) {
        List<Worker> convertWorkers = new ArrayList<>();
        for (int i = 0; i < workers.size(); i++) {
            convertWorkers.add(new Worker(workers.get(i)));
        }

        return convertWorkers;
    }
}
