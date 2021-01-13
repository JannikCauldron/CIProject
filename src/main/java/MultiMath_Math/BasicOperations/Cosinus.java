package MultiMath_Math.BasicOperations;


public class Cosinus {

    public static final String COSINUS_PATTERN = "^cos\\(\\s*-{0,1}\\d+\\s*\\)$";
    public static final String REPLACE_PATTERN = "\\D";

    public double calcCosinus(String op) {
        int numberOfSinusExpression;
        if (matchCosinusExpression(op)) {
            numberOfSinusExpression = extractNumberOfCosinusExpression(op);
            return Math.cos(numberOfSinusExpression);
        } else {
            throw new IllegalArgumentException("Error in cosinus expression");
        }
    }

    private int extractNumberOfCosinusExpression(String op) {
        String numberOnlyStr = op.replaceAll(REPLACE_PATTERN, "");
        int numberOfExpression = Integer.parseInt(numberOnlyStr);
        return numberOfExpression;
    }

    private boolean matchCosinusExpression(String op) {
        return op.matches(COSINUS_PATTERN);
    }
}
