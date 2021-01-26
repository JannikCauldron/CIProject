package MultiMath_Math.BasicOperations;

public class CommonLogarithm {
    public double logc(String operation) {
        String logcPattern = "logc\\([0-9]+\\)";
        double input;
        if (operation.matches(logcPattern)) {
            String numberString = operation.replaceAll("[^0-9]", "");
            input = Double.parseDouble(numberString);
        } else {
            return 0;
        }
        return Math.log10(input);
    }
}
