package MultiMath_Math.BasicOperations;

public class ArcusSinus {

	private static final String PATTERN_TO_REPLACE = "\\D";
    private static final String ARCSIN_PATTERN = "arcsin\\(\\d\\)";

    public double calcArcSin(String expression) {
        String arcSinPattern = ARCSIN_PATTERN;

        if (matchArcSinExpression(expression, arcSinPattern)) {
            return Math.asin(extractNumberFromArcSinString(expression));
        }
        
        return -1;
	}

    private boolean matchArcSinExpression(String expression, String arcSinPattern) {
        return expression.matches(arcSinPattern);
    }

    private double extractNumberFromArcSinString(String operation) {
        String extractedNumberString = operation.replaceAll(PATTERN_TO_REPLACE, "");
        return Double.parseDouble(extractedNumberString);
    }

}
