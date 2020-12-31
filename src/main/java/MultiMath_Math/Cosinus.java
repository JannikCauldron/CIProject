package MultiMath_Math;

public class Cosinus {

    public static final String COSINUS_PATTERN = "^cos\\([\\d]\\)$";
    public static final String REPLACE_PATTERN = "[\\D]";

    public double calcCosinus(String op) {
        int result;
        if (op.matches(COSINUS_PATTERN)) {
            String numberOnlyStr = op.replaceAll(REPLACE_PATTERN, "");
            result = Integer.parseInt(numberOnlyStr);
            return Math.cos(result);
        } else {
            throw new IllegalArgumentException("Error in cosinus expression");
        }
    }
}
