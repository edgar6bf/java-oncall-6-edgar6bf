package oncall.constant;

import java.util.Arrays;

public enum DayOfWeek {
    MONDAY("월", 0),
    TUESDAY("화", 1),
    WEDNESDAY("수", 2),
    THURSDAY("목", 3),
    FRIDAY("금", 4),
    SATURDAY("토", 5),
    SUNDAY("일", 6);

    private final String displayName;
    private final int sequence;

    DayOfWeek(String displayName, int sequence) {
        this.displayName = displayName;
        this.sequence = sequence;
    }

    public static DayOfWeek convertValueToDayOfWeek(String value) {
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.getDisplayName().equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 요일입니다. 다시 입력해주세요."));
    }

    public static DayOfWeek convertSequenceToDayOfWeek(int sequence) {
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.getSequence() == sequence)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 요일 시퀀스입니다."));
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getSequence() {
        return sequence;
    }
}
