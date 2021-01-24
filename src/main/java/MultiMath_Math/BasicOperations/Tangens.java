package MultiMath_Math.BasicOperations;

public class Tangens {

    public static final String TANGENS_PATTERN = "^tan\\(\\s*\\d+\\s*\\)$";
    public static final String REPLACE_PATTERN = "\\D";

    public double calcTangens(String input) {
        int result;

        if (matchTangensExpression(input)) {
            return Math.tan(extractNumberFromTangensExpression(input));
        }
        return -1;
    }

    private double extractNumberFromTangensExpression(String input) {
        String numberOnlyString = input.replaceAll(REPLACE_PATTERN, "");
        return Double.parseDouble(numberOnlyString);
    }

    private boolean matchTangensExpression(String input) {
        return input.matches(TANGENS_PATTERN);
    }
}
