package MultiMath_Math.BasicOperations;

public class Tangens {

    public static final String TANGENS_PATTERN = "^tan\\(\\s*-?[\\d]*\\s*\\)$";
    public static final String REPLACE_PATTERN = "[^-0-9]*";
    public static final String EXCEPTION_MSG_FOR_WRONG_TANGENS_EXPRESSION = "Error in tangens expression";

    public double calcTangens(String input) {
        if (matchTangensExpression(input)) {
            return Math.tan(extractNumberFromTangensExpression(input));
        } else {
            throw new IllegalArgumentException(EXCEPTION_MSG_FOR_WRONG_TANGENS_EXPRESSION);
        }
    }

    private double extractNumberFromTangensExpression(String input) {
        String numberOnlyString = input.replaceAll(REPLACE_PATTERN, "");
        return Double.parseDouble(numberOnlyString);
    }

    private boolean matchTangensExpression(String input) {
        return input.matches(TANGENS_PATTERN);
    }
}
