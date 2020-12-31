package MultiMath_Math;

public class Grundrechenarten {

    private String sinusPattern = "^sin\\(\\s*[1-9]+\\s*\\)$";

    public double calcSinus(String op) {
        int numberOfExpression;
        double result;
        if (op.matches(sinusPattern)) {
            String numberOnlyStr = op.replaceAll("[^0-9]", "");
            numberOfExpression = Integer.parseInt(numberOnlyStr);
        } else {
            throw new IllegalArgumentException("No valid expression: " + op);
        }
        result = Math.sin(numberOfExpression);
        return result;
    }
}
