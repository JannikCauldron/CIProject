package MultiMath_Math.BasicOperations;

public class NaturalLogarithm {

    private final String LOGN_PATTERN = "logn\\s*\\(\\s*[1-9][0-9]+(\\.[0-9]+)?\\s*\\)|logn\\s*\\(\\s*[0-9](\\.[0-9]+)?\\s*\\)";

    public double logn(String operation) {
        double number;
        int operationStringLength = operation.length();

        if (operation.matches(LOGN_PATTERN)) {
            number = DecimalFilter.getNumber(operation, operationStringLength);
        } else {
            throw new IllegalArgumentException("no valid natural logarithm expression: " + operation);
        }
        return Math.log(number);
    }
}
