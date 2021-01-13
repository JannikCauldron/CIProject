package MultiMath_Math.BasicOperations;


public class Cosinus {

    public static final String COSINUS_PATTERN = "^cos\\(\\s*-{0,1}[1-9][\\d]*\\s*\\)$|^cos\\(\\s*0\\s*\\)$";
    public static final String REPLACE_PATTERN = "\\D";

    public double calcCosinus(String op) {
        if (matchCosinusExpression(op)) {
            return Math.cos(extractNumberOfCosinusExpression(op));
        } else {
            throw new IllegalArgumentException("Error in cosinus expression");
        }
    }

    private int extractNumberOfCosinusExpression(String op) {
        String numberOnlyStr = op.replaceAll(REPLACE_PATTERN, "");
        return Integer.parseInt(numberOnlyStr);
    }

    private boolean matchCosinusExpression(String op) {
        return op.matches(COSINUS_PATTERN);
    }
}
