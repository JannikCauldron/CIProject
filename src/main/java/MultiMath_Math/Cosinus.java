package MultiMath_Math;

public class Cosinus {
    public double calcCosinus(String op) {
        String pattern = "^cos\\([\\d]\\)$";
        int result;
        if (op.matches(pattern)) {
            String numberOnlyStr = op.replaceAll("[\\D]", "");
            result = Integer.parseInt(numberOnlyStr);
            return Math.cos(result);
        } else {
            throw new IllegalArgumentException("wrong expression");
        }
    }
}
