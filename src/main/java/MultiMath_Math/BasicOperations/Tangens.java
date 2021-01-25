package MultiMath_Math.BasicOperations;

public class Tangens {

    public static final String TANGENS_PATTERN = "^tan\\(\\s*-?[1-9][\\d]*\\s*\\)$";
    public static final String PATTERN_TO_REPLACE = "[^-0-9]*";
    public static final String EXCEPTION_MSG_TANGENS = "Error in tangens expression";

    public double calcTangens(String input) {
        if (matchTangensExpression(input)) {
            return Math.tan(extractNumberFromTangensExpression(input));
        } else {
            throw new IllegalArgumentException(EXCEPTION_MSG_TANGENS);
        }
    }

    private double extractNumberFromTangensExpression(String input) {
        String numberOnlyString = input.replaceAll(PATTERN_TO_REPLACE, "");
        return Double.parseDouble(numberOnlyString);
    }

    private boolean matchTangensExpression(String input) {
        return input.matches(TANGENS_PATTERN);
    }
}
