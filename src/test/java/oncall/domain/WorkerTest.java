package oncall.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WorkerTest {

    @DisplayName("유효한 근로자 이름을 입력하면 정상적으로 객체가 생성된다.")
    @Test
    void inputValidName() throws Exception {
        // Given
        String validName = "포비";

        // When
        Worker worker = new Worker(validName);

        // Then
        assertThat(worker).isNotNull();
    }

    @DisplayName("빈 근로자 이름을 입력하면 예외가 발생한다.")
    @Test
    void inputEmptyName() throws Exception {
        // Given
        String emptyName = "";

        // When & Then
        Assertions.assertThatThrownBy(() -> new Worker(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1 ~ 5 길이만 가능합니다.");
    }

    @DisplayName("유효 범위보다 긴 근로자 이름을 입력하면 예외가 발생한다.")
    @Test
    void inputSoLongName() throws Exception {
        // Given
        String soLongName = "so-long-name";

        // When & Then
        Assertions.assertThatThrownBy(() -> new Worker(soLongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1 ~ 5 길이만 가능합니다.");
    }

    @DisplayName("전날 근무한 근무자면 true를 반환한다.")
    @Test
    void returnTrueWhenWorkYesterdayWorker() throws Exception {
        // Given
        Worker worker = new Worker("포비");
        worker.updateLastWorkDay(5);

        // When
        boolean isWorkYesterday = worker.isWorkYesterday(6);

        // Then
        Assertions.assertThat(isWorkYesterday).isTrue();
    }

    @DisplayName("전날 근무한 근무자가 아니면 false를 반환한다.")
    @Test
    void returnFalseWhenNotWorkYesterdayWorker() throws Exception {
        // Given
        Worker worker = new Worker("포비");
        worker.updateLastWorkDay(5);

        // When
        boolean isWorkYesterday = worker.isWorkYesterday(7);

        // Then
        Assertions.assertThat(isWorkYesterday).isFalse();
    }
}
