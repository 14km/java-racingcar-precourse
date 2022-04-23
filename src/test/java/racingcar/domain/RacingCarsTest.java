package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.Messages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc,null,test"})
    void 레이싱_자동차_설정(String input) {
        String[] strings = input.split(",");

        racingCars.addRacingCar(strings);

        // then
        Assertions.assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdefg,car"})
    void 자동차_등록_중_이름_글자수를_초과한_경우(String input) {
        String[] strings = input.split(",");

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> racingCars.addRacingCar(strings))
                .withMessageContaining(Messages.EXCEED_CAR_NAME_MAX_LENGTH);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc,def,,car"})
    void 자동차_등록_중_이름_비어있는_경우(String input) {
        String[] strings = input.split(",");

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> racingCars.addRacingCar(strings))
                .withMessageContaining(Messages.CAR_NAME_NOT_EMPTY);
    }

    @Test
    void 자동차_등록_중_이름_NULL_경우() {
        String[] strings = {"abb", "deff", null, "gg"};

        // then
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> racingCars.addRacingCar(strings))
                .withMessageContaining(Messages.CAR_NAME_NOT_NULL);
    }
}
