package MultiMath_Math.BasicOperations;

public class Tangens {

    public static final String TANGENS_PATTERN = "^tan\\(\\d+\\)$";
    public static final String REPLACE_PATTERN = "\\D";

    public double calcTangens(String input) {
        int result;

        if (input.matches(TANGENS_PATTERN)) {
            String extractNumber = input.replaceAll(REPLACE_PATTERN, "");
            result = Integer.parseInt(extractNumber);
            return Math.tan(result);
        }
        return -1;
    }
}
