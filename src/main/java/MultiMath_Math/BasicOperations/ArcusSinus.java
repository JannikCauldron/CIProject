package MultiMath_Math.BasicOperations;

public class ArcusSinus {

	private static final int ERROR = -1;
    private static final String PATTERN_TO_REPLACE = "\\D";
    private static final String ARCSIN_PATTERN = "arcsin\\(\\s*\\d+\\s*\\)";

    public double processArcSinExpression(String expression) {

        if (matchArcSinExpression(expression)) {
            return calcArcusSinus(expression);
        }
        
        return ERROR;
	}

    private double calcArcusSinus(String expression) {
        return Math.asin(extractNumberFromArcSinString(expression));
    }

    private boolean matchArcSinExpression(String expression) {
        return expression.matches(ARCSIN_PATTERN);
    }

    private double extractNumberFromArcSinString(String operation) {
        String extractedNumberString = operation.replaceAll(PATTERN_TO_REPLACE, "");
        return Double.parseDouble(extractedNumberString);
    }

}
