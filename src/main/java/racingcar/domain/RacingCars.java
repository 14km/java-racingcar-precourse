package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars = new ArrayList<>();

    public void addRacingCar(String[] names) {
        for (String name : names) {
            RacingCar racingCar = new RacingCar(new RacingCarName(name));
            racingCars.add(racingCar);
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
