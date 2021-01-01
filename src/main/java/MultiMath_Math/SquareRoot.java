package MultiMath_Math;

public class SquareRoot {

    private final String SQRT_PATTERN = "sqrt\\(\\s*[1-9][0-9]+(\\.[0-9]+)?\\s*\\)|sqrt\\(\\s*[0-9](\\.[0-9]+)?\\s*\\)";

    public double rooted(String operation) {

        double number;
        int indexOfDot;
        int operationStringLength = operation.length();
        String stringBeforeDot;
        String stringAfterDot;

        if (operation.matches(SQRT_PATTERN)) {
            if (operation.contains(".")) {
                indexOfDot = operation.indexOf('.');

                stringBeforeDot = operation.substring(0, indexOfDot);
                stringAfterDot = operation.substring(indexOfDot+1, operationStringLength);

                String numberStringBeforeDot = stringBeforeDot.replaceAll("[^0-9]", "");
                String numberStringAfterDot = stringAfterDot.replaceAll("[^0-9]", "");

                String completeNumberString = numberStringBeforeDot + "." + numberStringAfterDot;
                number = Double.parseDouble(completeNumberString);
            } else {
                String numberString = operation.replaceAll("[^0-9]", "");
                number = Double.parseDouble(numberString);
            }
        } else {
            throw new IllegalArgumentException("no valid root expression: " + operation);
        }
        return Math.sqrt(number);
    }
}
