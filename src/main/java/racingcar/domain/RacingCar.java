package racingcar.domain;

public class RacingCar {
    public static final int MOVING_CONDITION = 4;
    public static final String MARK = "-";

    private int currentLocation = 0;
    private final RacingCarName carName;

    public RacingCar(RacingCarName carName) {
        this.carName = carName;
    }

    public void move(int random) {
        if (MOVING_CONDITION <= random) {
            this.currentLocation++;
        }

        System.out.println(currentLocationMark());
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public String getCarName() {
        return carName.getName();
    }

    public String currentLocationMark() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < currentLocation; i++) {
            stringBuilder.append(MARK);
        }

        return String.format("%s : %s", this.carName.getName(), stringBuilder);
    }
}
