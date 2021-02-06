package MultiMath_Math.BasicOperations;

public class SquareRoot {

    private final String SQRT_PATTERN = "sqrt\\(\\s*[1-9][0-9]+(\\.[0-9]+)?\\s*\\)|sqrt\\(\\s*[0-9](\\.[0-9]+)?\\s*\\)";

    public double rooted(String operation) {

        double number;
        int operationStringLength = operation.length();

        if (operation.matches(SQRT_PATTERN)) {
            number = DecimalFilter.getNumber(operation, operationStringLength);
        } else {
            throw new IllegalArgumentException("no valid root expression: " + operation);
        }
        return Math.sqrt(number);
    }
}
