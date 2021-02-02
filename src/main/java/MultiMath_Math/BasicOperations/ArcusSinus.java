package MultiMath_Math.BasicOperations;

public class ArcusSinus {

	private static final String PATTERN_TO_REPLACE = "\\D";
    private static final String ARCSIN_PATTERN = "arcsin\\(\\d+\\)";

    public double calcArcSin(String expression) {

        if (matchArcSinExpression(expression)) {
            return Math.asin(extractNumberFromArcSinString(expression));
        }
        
        return -1;
	}

    private boolean matchArcSinExpression(String expression) {
        return expression.matches(ARCSIN_PATTERN);
    }

    private double extractNumberFromArcSinString(String operation) {
        String extractedNumberString = operation.replaceAll(PATTERN_TO_REPLACE, "");
        return Double.parseDouble(extractedNumberString);
    }

}
