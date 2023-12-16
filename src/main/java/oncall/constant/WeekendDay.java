package oncall.constant;

import java.util.Arrays;

import static oncall.constant.Month.*;

public enum WeekendDay {

    NEW_YEAR(JANUARY, 1),         // 신정(1월 1일)
    INDEPENDENCE_MOVEMENT(MARCH, 1), // 삼일절(3월 1일)
    CHILDRENS_DAY(MAY, 5),          // 어린이날(5월 5일)
    MEMORIAL_DAY(JUNE, 6),           // 현충일(6월 6일)
    LIBERATION_DAY(AUGUST, 15),     // 광복절(8월 15일)
    FOUNDATION_DAY(OCTOBER, 3),     // 개천절(10월 3일)
    HANGUL_DAY(OCTOBER, 9),         // 한글날(10월 9일)
    CHRISTMAS(DECEMBER, 25);        // 성탄절(12월 25일)

    private final Month month;
    private final int day;

    WeekendDay(Month month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isWeekend(Month month, int day) {
        return Arrays.stream(WeekendDay.values())
                .anyMatch(weekendDay -> weekendDay.getMonth() == month && weekendDay.getDay() == day);
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
