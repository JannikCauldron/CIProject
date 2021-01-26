package MultiMath_Math.BasicOperations;

public class CommonLogarithm {
    private final String LOGC_PATTERN = "logc\\s*\\(\\s*[1-9]+\\s*\\)";

    public double logc(String inputString) {
        double inputNumber;
        if (inputString.matches(LOGC_PATTERN)) {
            String numberString = inputString.replaceAll("[^0-9]", "");
            inputNumber = Double.parseDouble(numberString);
        } else {
            throw new IllegalArgumentException("no valid common logarithm expression: " + inputString);
        }
        return Math.log10(inputNumber);
    }
}
