package MultiMath_Math.BasicOperations;

public class Sinus {

    private static final String SINUS_PATTERN = "^sin\\(\\s*[-1-9][0-9]*\\s*\\)$|^sin\\(\\s*0\\s*\\)";
    private static final String SINUS_REPLACE_PATTERN = "[a-z\\(\\)\\s]";

    public double calcSinus(String op) {
        double result;
        int numberOfExpression;
        if (matchSinus(op)) {
            numberOfExpression = extractNumberOfSinusExpression(op);
        } else {
            throw new IllegalArgumentException("No valid expression: " + op);
        }
        result = Math.sin(numberOfExpression);
        return result;
    }

    private int extractNumberOfSinusExpression(String op) {
        int numberOfExpression;
        String numberOnlyStr = op.replaceAll(SINUS_REPLACE_PATTERN, "");
        numberOfExpression = Integer.parseInt(numberOnlyStr);
        return numberOfExpression;
    }

    private boolean matchSinus(String op) {
        return op.matches(SINUS_PATTERN);
    }
}
