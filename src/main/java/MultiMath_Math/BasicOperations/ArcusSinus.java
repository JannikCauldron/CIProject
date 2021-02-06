package MultiMath_Math.BasicOperations;

public class ArcusSinus {

    private static final String EXCEPTION_MESSAGE_FOR_WRONG_INPUT = "Mistake in arcus sinus expression";
    private static final IllegalArgumentException EXCEPTION_FOR_WRONG_USER_INPUT = new IllegalArgumentException(
            EXCEPTION_MESSAGE_FOR_WRONG_INPUT);
    private static final String PATTERN_TO_REPLACE = "\\D";
    private static final String ARCSIN_PATTERN = "arcsin\\(\\s*-?\\d+\\s*\\)";

    public double processArcSinExpression(String arcSinExpression) {

        if (matchArcSinExpression(arcSinExpression)) {
            return calcArcusSinus(arcSinExpression);
        } else {

            throw EXCEPTION_FOR_WRONG_USER_INPUT;
        }

    }

    private double calcArcusSinus(String arcSinValue) {
        return Math.asin(extractNumberFromArcSinString(arcSinValue));
    }

    private boolean matchArcSinExpression(String expressionToMatch) {
        return expressionToMatch.matches(ARCSIN_PATTERN);
    }

    private double extractNumberFromArcSinString(String stringExpression) {
        String extractedNumberString = stringExpression.replaceAll(PATTERN_TO_REPLACE, "");
        return Double.parseDouble(extractedNumberString);
    }

}
