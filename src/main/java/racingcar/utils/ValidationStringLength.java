package racingcar.utils;

public class ValidationStringLength {
    private static final int MAX_LENGTH = 5;

    public static boolean validationLength(String input) {
       return input.length() <= MAX_LENGTH;
    }
}
