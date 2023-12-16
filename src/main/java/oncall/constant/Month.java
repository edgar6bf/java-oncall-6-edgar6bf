package oncall.constant;

import java.util.Arrays;

public enum Month {

    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    private final int numberValue;
    private final int days;

    Month(int numberValue, int days) {
        this.numberValue = numberValue;
        this.days = days;
    }

    public static Month convertToMonth(int monthValue) {
        return Arrays.stream(Month.values())
                .filter(month -> month.getNumberValue() == monthValue)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 월 입력입니다. 다시 입력해주세요."));
    }

    public int getNumberValue() {
        return numberValue;
    }

    public int getDays() {
        return days;
    }
}
