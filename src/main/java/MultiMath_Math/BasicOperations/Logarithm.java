package MultiMath_Math.BasicOperations;

public class Logarithm {

    private final String LOG_PATTERN = "log\\s*\\(\\s*[1-9][0-9]+(\\.[0-9]+)?\\s*\\)|log\\s*\\(\\s*[0-9](\\.[0-9]+)?\\s*\\)";

    public double log(String operation) {
        double number;
        int indexOfDot;
        String stringBeforeDot;
        String stringAfterDot;
        int operationStringLength = operation.length();

        if (operation.matches(LOG_PATTERN)) {
            if (operation.contains(".")) {
                indexOfDot = operation.indexOf('.');

                stringBeforeDot = operation.substring(0, indexOfDot);
                stringAfterDot = operation.substring(indexOfDot+1, operationStringLength);

                String numberStringBeforeDot = stringBeforeDot.replaceAll("[^0-9]", "");
                String numberStringAfterDot = stringAfterDot.replaceAll("[^0-9]", "");

                String completeNumberString = numberStringBeforeDot + "." + numberStringAfterDot;
                number = Double.parseDouble(completeNumberString);
            } else {
                String completeNumberString = operation.replaceAll("[^0-9]", "");
                number = Double.parseDouble(completeNumberString);
            }
        } else {
            throw new IllegalArgumentException("no valid logarithm expression: " + operation);
        }
        return Math.log(number);
    }
}
