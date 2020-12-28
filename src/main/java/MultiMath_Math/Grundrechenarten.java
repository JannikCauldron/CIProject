package MultiMath_Math;

public class Grundrechenarten {

    private String sinusPattern = "^sin\\([0-9]+\\)$";

    public double calcSinus(String op) {
        int numberOfExpression;

        if (op.matches(sinusPattern)) {
            String numberOnlyStr = op.replaceAll("[^0-9]", "");
            numberOfExpression = Integer.parseInt(numberOnlyStr);
        } else {
            throw new IllegalArgumentException("No valid expression: " + op);
        }
        return Math.sin(numberOfExpression);
    }
}
