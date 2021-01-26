package MultiMath_Math.BasicOperations;

public class Logarithm {
    public double log(String op) {
        String logPattern = "log\\([0-9]+\\)";
        double input;
        if (op.matches(logPattern)) {
            String numberString = op.replaceAll("[^0-9]", "");
            input = Double.parseDouble(numberString);
        } else {
            return 0;
        }
        return Math.log(input);
    }
}
