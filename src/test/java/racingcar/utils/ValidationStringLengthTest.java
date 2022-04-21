package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationStringLengthTest {

    @Test
    void 최대_문자열_길이_테스트() {
        assertThat(ValidationStringLength.validationLength("ABC")).isTrue();
        assertThat(ValidationStringLength.validationLength("crong")).isTrue();
        assertThat(ValidationStringLength.validationLength("자동자경주게임")).isFalse();
        assertThat(ValidationStringLength.validationLength("programmer")).isFalse();
    }
}
