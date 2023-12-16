package oncall.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WorkersTest {

    @DisplayName("유효한 평일 & 주말 근무자 목록을 입력하면 정상적으로 객체가 생성된다.")
    @Test
    void inputValidInput() throws Exception {
        // Given
        List<String> weekdayWorkers = List.of("준팍", "도밥", "고니", "수아", "루루",
                "글로", "솔로스타", "우코", "슬링키", "참새", "도리");
        List<String> weekendWorkers = List.of("수아", "루루", "글로", "솔로스타", "우코",
                "슬링키", "참새", "도리", "준팍", "도밥", "고니");

        // When
        Workers workers = new Workers(weekdayWorkers, weekendWorkers);

        // Then
        Assertions.assertThat(workers).isNotNull();
    }

    @DisplayName("중복된 근무자가 입력되면 예외가 발생한다.")
    @Test
    void inputDuplicatedValues() throws Exception {
        // Given
        List<String> weekdayWorkers = List.of("준팍", "도밥", "고니", "수아", "루루",
                "글로", "솔로스타", "우코", "슬링키", "참새", "도리");
        List<String> weekendWorkersContainsDuplicatedValue = List.of("수아", "수아", "글로", "솔로스타", "우코",
                "슬링키", "참새", "도리", "준팍", "도밥", "고니");

        // When & Then
        Assertions.assertThatThrownBy(() -> new Workers(weekdayWorkers, weekendWorkersContainsDuplicatedValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비상 근무자를 중복 입력할 수 없습니다. 다시 입력하세요.");
    }

    @DisplayName("유효 범위보다 외 근무자가 입력되면 예외가 발생한다.")
    @Test
    void inputInvalidRange() throws Exception {
        // Given
        List<String> invalidRange = List.of("준팍", "도밥");
        List<String> weekendWorkers = List.of("수아", "글로", "솔로스타", "우코",
                "슬링키", "참새", "도리", "준팍", "도밥", "고니");

        // When & Then
        Assertions.assertThatThrownBy(() -> new Workers(invalidRange, weekendWorkers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비상 근무자 배치는 5 ~ 35명만 가능합니다. 다시 입력하세요.");
    }
}
