package MultiMath_Math.BasicOperations;

public class CommonLogarithm {
    private final String LOGC_PATTERN = "logc\\s*\\(\\s*[1-9][0-9]+(\\.[0-9]+)?\\s*\\)|logc\\s*\\(\\s*[0-9](\\.[0-9]+)?\\s*\\)";

    public double logc(String operation) {

        double number;
        int operationStringLength = operation.length();

        if (operation.matches(LOGC_PATTERN)) {
            number = DecimalFilter.getNumber(operation, operationStringLength);
        } else {
            throw new IllegalArgumentException("no valid common logarithm expression: " + operation);
        }
        return Math.log10(number);
    }
}
