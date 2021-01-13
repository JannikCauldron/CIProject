package MultiMath_Math.BasicOperations;


public class Cosinus {

    public static final String COSINUS_PATTERN = "^cos\\(\\s*-{0,1}\\d+\\s*\\)$";
    public static final String REPLACE_PATTERN = "\\D";

    public double calcCosinus(String op) {
        int result;
        if (isMatch(op)) {
            String numberOnlyStr = op.replaceAll(REPLACE_PATTERN, "");
            result = Integer.parseInt(numberOnlyStr);
            return Math.cos(result);
        } else {
            throw new IllegalArgumentException("Error in cosinus expression");
        }
    }

    private boolean isMatch(String op) {
        return op.matches(COSINUS_PATTERN);
    }
}
