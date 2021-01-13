package MultiMath_Math.BasicOperations;

public class Sinus {

    private String SINUS_PATTERN = "^sin\\(\\s*[-1-9][0-9]*\\s*\\)$|^sin\\(\\s*0\\s*\\)";

    public double calcSinus(String op) {
        int numberOfExpression;
        double result;
        if (matchSinus(op)) {
            String numberOnlyStr = extractNumberOfSinusExpression(op);
            numberOfExpression = Integer.parseInt(numberOnlyStr);
        } else {
            throw new IllegalArgumentException("No valid expression: " + op);
        }
        result = Math.sin(numberOfExpression);
        return result;
    }

    private String extractNumberOfSinusExpression(String op) {
        String numberOnlyStr = op.replaceAll("[a-z\\(\\)\\s]", "");
        return numberOnlyStr;
    }

    private boolean matchSinus(String op) {
        return op.matches(SINUS_PATTERN);
    }
}
