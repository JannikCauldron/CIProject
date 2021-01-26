package MultiMath_Math.BasicOperations;

public class CommonLogarithm {
    private final String LOGC_PATTERN = "logc\\s*\\(\\s*[1-9][0-9]+(\\.[0-9]+)?\\s*\\)|logc\\s*\\(\\s*[0-9](\\.[0-9]+)?\\s*\\)";

    public double logc(String operation) {

        double number;
        int indexOfDot;
        String stringBeforeDot;
        String stringAfterDot;
        int operationStringLength = operation.length();

        if (operation.matches(LOGC_PATTERN)) {
            if (operation.contains(".")) {

                indexOfDot = operation.indexOf('.');

                stringBeforeDot = operation.substring(0, indexOfDot);
                stringAfterDot = operation.substring(indexOfDot+1, operationStringLength);

                String numberStringBeforeDot = stringBeforeDot.replaceAll("[^0-9]", "");
                String numberStringAfterDot = stringAfterDot.replaceAll("[^0-9]", "");
                String CompleteNumberString = numberStringBeforeDot + "." + numberStringAfterDot;

                number = Double.parseDouble(CompleteNumberString);

            } else {
                String CompleteNumberString = operation.replaceAll("[^0-9]", "");
                number = Double.parseDouble(CompleteNumberString);
            }
        } else {
            throw new IllegalArgumentException("no valid common logarithm expression: " + operation);
        }
        return Math.log10(number);
    }
}
