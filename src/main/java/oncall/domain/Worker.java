package oncall.domain;

public class Worker {

    private static final int ALLOWED_MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    private int lastWorkDay = 0;

    public Worker(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > ALLOWED_MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1 ~ 5 길이만 가능합니다.");
        }
    }

    public boolean isWorkYesterday(int day) {
        return lastWorkDay != 0 && (day - 1) == lastWorkDay;
    }

    public void updateLastWorkDay(int day) {
        this.lastWorkDay = day;
    }

    public String getName() {
        return name;
    }
}
