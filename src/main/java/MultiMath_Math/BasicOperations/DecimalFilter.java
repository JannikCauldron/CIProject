package MultiMath_Math.BasicOperations;

public class DecimalFilter {
    static double getNumber(String operation, int operationStringLength) {
        int indexOfDot;
        String stringBeforeDot;
        String stringAfterDot;
        double number;
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
        return number;
    }
}
