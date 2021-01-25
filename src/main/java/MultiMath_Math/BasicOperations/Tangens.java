package MultiMath_Math.BasicOperations;

public class Tangens {

    public static final String TANGENS_PATTERN = "^tan\\(\\s*-?[1-9][\\d]*\\s*\\)$";
    public static final String PATTERN_TO_REPLACE = "[^-0-9]*";
    public static final String EXCEPTION_MSG_TANGENS = "Error in tangens expression";

    public double calcTangens(String tangensExpression) {
        if (matchTangensExpression(tangensExpression)) {
            return Math.tan(extractNumberFromTangensExpression(tangensExpression));
        } else {
            throw new IllegalArgumentException(EXCEPTION_MSG_TANGENS);
        }
    }

    private double extractNumberFromTangensExpression(String tangensExpression) {
        String extractedNumbersOfTangensExpression = tangensExpression.replaceAll(PATTERN_TO_REPLACE, "");
        return Double.parseDouble(extractedNumbersOfTangensExpression);
    }

    private boolean matchTangensExpression(String tangensExpression) {
        return tangensExpression.matches(TANGENS_PATTERN);
    }
}
