package oncall.constant;

import java.util.Arrays;

public enum DayOfWeek {
    SUNDAY("일"),
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토");

    private final String displayName;

    DayOfWeek(String displayName) {
        this.displayName = displayName;
    }

    public static DayOfWeek convertToDayOfWeek(String value) {
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.getDisplayName().equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 요일입니다. 다시 입력해주세요."));
    }

    public String getDisplayName() {
        return displayName;
    }
}
